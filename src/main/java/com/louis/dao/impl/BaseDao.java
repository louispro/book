package com.louis.dao.impl;

/**
 * @赖小燚
 * @www.louis_lai.com
 */

import com.louis.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 使用dbutils操作数据库
 */
public abstract class BaseDao {

    private QueryRunner queryRunner = new QueryRunner();

    /**
     * 增删改操作
     * @param sql
     * @param args
     * @return
     */
    public int update(String sql,Object...args){
        Connection connection = JDBCUtils.getConnection();
        try {
            return queryRunner.update(connection,sql,args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }

    /**
     * 查询单个值操作
     * @param type
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public <T> T queryForOne(Class<T> type,String sql,Object...args){
        Connection conn = JDBCUtils.getConnection();
        try {
            return queryRunner.query(conn,sql,new BeanHandler<T>(type),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * 查询多个结果
     * @param type
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object...args){
        Connection conn = JDBCUtils.getConnection();
        try {
            return queryRunner.query(conn,sql,new BeanListHandler<T>(type),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * 查询单个值
     * @param sql
     * @param args
     * @return
     */
    public Object queryForSingleValue(String sql,Object...args){
        Connection conn = JDBCUtils.getConnection();
        try {
            return queryRunner.query(conn,sql,new ScalarHandler<>(),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
