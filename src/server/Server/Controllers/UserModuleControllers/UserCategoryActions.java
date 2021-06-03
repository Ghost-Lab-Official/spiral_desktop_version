package server.Server.Controllers.UserModuleControllers;

/**
 * @author : Ineza Aimee Annabelle
 * @description: This is where user category actions are executed
 */


import server.Server.DbController.CloudStorageConnectionHandler;
import server.Server.Model.ResponseStatus;
import server.Server.Model.UserCategory;

import java.net.ConnectException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserCategoryActions {
    String InsertSql = "INSERT INTO users_categories (user_category) VALUES(?)";
    String UpdateSql = "UPDATE users_categories SET user_category=?,category_status=? WHERE category_id=?";
    String UpdateUserStatus = "UPDATE users_table SET user_status=? WHERE category_id=?";
    String deleteSQL = "DELETE FROM users_categories WHERE category_id=?";
    String selectSQL = "SELECT * FROM users_categories";
    String selectToCreateSQL = "Select *from users_categories where user_category=?";


    public ResponseStatus createUserCategory(UserCategory userCategoryToRegister)throws Exception{
        Connection connection = new CloudStorageConnectionHandler().getConnection();

        PreparedStatement statement = connection.prepareStatement(selectToCreateSQL);
        statement.setString(1,userCategoryToRegister.getCatName());
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next() == true){
            return new ResponseStatus(400,"BAD REQUEST","This Category is already registered");
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(InsertSql)){
            preparedStatement.setString(1,userCategoryToRegister.getCatName());
            int inserted = preparedStatement.executeUpdate();

            if(inserted == 1){
                return new ResponseStatus(200,"USER CATEGORY RECORDED","You have inserted the user category");
            }
        }
        catch (SQLException e){
             return  new ResponseStatus(400,"BAD REQUEST",e.getMessage());
        }
        catch (Exception e){
            new ResponseStatus(500,"SERVER ERROR",e.getMessage());
        }
        return null;
    }
    public List<Object> selectCategories() throws Exception{
        Connection connection = new CloudStorageConnectionHandler().getConnection();
        Statement state= connection.createStatement();
        ResultSet result =state.executeQuery(selectSQL);
        List<Object> userCategories = new ArrayList<>();

        while (result.next()){
           UserCategory userCategory = new UserCategory();
           userCategory.setCatId(result.getInt(1));
           userCategory.setCatName(result.getString(2));
           userCategories.add((Object) userCategory);
        }
        return  userCategories;
    }

    public List<Object> selectCategoriesById(UserCategory userCategory) throws Exception{
        Connection connection = new CloudStorageConnectionHandler().getConnection();
        Statement state= connection.createStatement();
        ResultSet result =state.executeQuery("SELECT * FROM users_categories WHERE category_id="+userCategory.getCatId());

        List<Object> userCategories = new ArrayList<>();

        while (result.next()){
            UserCategory userCat = new UserCategory();
            userCat.setCatId(result.getInt(1));
            userCat.setCatName(result.getString(2));
            userCategories.add((Object) userCat);
        }
        return  userCategories;
    }

    public ResponseStatus updateCategory(UserCategory userCategoryToUpdate) throws Exception {
        Connection connection = new CloudStorageConnectionHandler().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UpdateSql)){
            preparedStatement.setInt(3,userCategoryToUpdate.getCatId());
            preparedStatement.setString(1,userCategoryToUpdate.getCatName());
            preparedStatement.setString(2,userCategoryToUpdate.getCatStatus());
            int updated = preparedStatement.executeUpdate();

            if(updated == 1){
                return new ResponseStatus(200,"USER CATEGORY UPDATED","You have updated the user category");
            }
        }
        catch (SQLException e){
            return  new ResponseStatus(400,"BAD REQUEST",e.getMessage());
        }
        catch (Exception e){
            new ResponseStatus(500,"SERVER ERROR",e.getMessage());
        }
        return new ResponseStatus(500,"SERVER ERROR","Server is done , not running ....");
    }
    public ResponseStatus deleteUserCategory(UserCategory userCategoryToDelete) throws Exception{
        Connection connection = new CloudStorageConnectionHandler().getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)){
            preparedStatement.setInt(1, userCategoryToDelete.getCatId());
            int deleted = preparedStatement.executeUpdate();
            if(deleted == 1){
                updateStatus(userCategoryToDelete.getCatId(),"inactive");
                return new ResponseStatus(200,"USER CATEGORY DELETED","You have updated the user category");
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            return  new ResponseStatus(400,"BAD REQUEST",e.getMessage());
        }
        catch (Exception e){
            new ResponseStatus(500,"SERVER ERROR",e.getMessage());
        }
        return new ResponseStatus(500,"SERVER ERROR","e.getMessage()");
    }
    public ResponseStatus updateStatus(Integer categoryId,String categoryName) throws Exception {
        CloudStorageConnectionHandler cloudStorageConnection = new CloudStorageConnectionHandler();
        Connection connection = cloudStorageConnection.getConnection();
        try(PreparedStatement statement = connection.prepareStatement(UpdateUserStatus)) {
            statement.setInt(2, categoryId);
            statement.setString(1, categoryName);
            int updated = statement.executeUpdate();
            if (updated == 1) {
                return new ResponseStatus(200, "USERS WITH THE SAME STATUS UPDATED", "User with the same changes is now updated");
            }
        }  catch (SQLException e){
            System.out.println(e.getMessage());
            return  new ResponseStatus(400,"BAD REQUEST",e.getMessage());
        } catch (Exception e){
            new ResponseStatus(500,"SERVER ERROR",e.getMessage());
        }
        return new ResponseStatus(500,"SERVER ERROR","e.getMessage()");
    }
}
