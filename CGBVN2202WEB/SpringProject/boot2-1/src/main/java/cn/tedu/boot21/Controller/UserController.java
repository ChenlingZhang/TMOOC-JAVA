package cn.tedu.boot21.Controller;

import cn.tedu.boot21.Entity.User;
import cn.tedu.boot21.utils.DButils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Controller
public class UserController {
    @RequestMapping("/reg")
    @ResponseBody
    public String reg(User user) throws SQLException {
        String username = user.getUsername();
        String password = user.getPassword();
        String nick = user.getNickname();
        try (Connection connection = DButils.getConn()) {
            String check = "select count(*) from user where username=?";
            PreparedStatement checkStatement = connection.prepareStatement(check);
            checkStatement.setString(1, username);
            ResultSet set = checkStatement.executeQuery();
            set.next();
            if (set.getInt(1) > 0) {
                return "用户已存在";
            } else {
                String sql = "insert into user(username,password,nick) values(?,?,?);";
                PreparedStatement updatestatement = connection.prepareStatement(sql);
                updatestatement.setString(1, username);
                updatestatement.setString(2, password);
                updatestatement.setString(3, nick);
                updatestatement.executeUpdate();
            }
        }
        return "注册成功" + user.toString();
    }

    @RequestMapping("login")
    @ResponseBody
    public String login(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        try (Connection connection = DButils.getConn()) {
            String login = "select password from user where username = ?";
            PreparedStatement statement = connection.prepareStatement(login);
            statement.setString(1, username);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                if (set.getString(1).equals(user.getPassword())) {
                    return "登陆成功";
                } else {
                    return "密码错误";
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "用户名错误";
    }
}
