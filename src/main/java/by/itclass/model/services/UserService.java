package by.itclass.model.services;

import by.itclass.model.db.DbInMemory;
import by.itclass.model.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserService {
    public List<User> getUsersByCriteria(Map<String,String[]> params){
        List<User> users = new ArrayList<>();
        String s = params.get("criteria")[0];
        switch (s){
            case "name" :{
                String name = params.get("name")[0];
                users.add(DbInMemory.findUserByName(name));
                users = users.stream()
                        .filter(Objects::nonNull)
                        .collect(Collectors.toList());
                break;
            }
            case "id":{
                String fromId =params.get("fromId")[0];
                String toId =params.get("toId")[0];
                int from = Integer.parseInt(fromId);
                int to = Integer.parseInt(toId);
                users = DbInMemory.findUsersById(from,to);
                break;
            }
            default:break;
        }
        return users;
    }
}
