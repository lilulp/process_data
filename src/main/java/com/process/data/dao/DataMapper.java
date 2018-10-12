package com.process.data.dao;

import com.process.data.pojo.Data;
import com.process.data.pojo.DataExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface DataMapper {
    @SelectProvider(type=DataSqlProvider.class, method="countByExample")
    long countByExample(DataExample example);

    @DeleteProvider(type=DataSqlProvider.class, method="deleteByExample")
    int deleteByExample(DataExample example);

    @Delete({
        "delete from data",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into data (id, data)",
        "values (#{id,jdbcType=INTEGER}, #{data,jdbcType=DECIMAL})"
    })
    int insert(Data record);

    @InsertProvider(type=DataSqlProvider.class, method="insertSelective")
    int insertSelective(Data record);

    @SelectProvider(type=DataSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="data", property="data", jdbcType=JdbcType.DECIMAL)
    })
    List<Data> selectByExample(DataExample example);

    @Select({
        "select",
        "id, data",
        "from data",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="data", property="data", jdbcType=JdbcType.DECIMAL)
    })
    Data selectByPrimaryKey(Integer id);

    @UpdateProvider(type=DataSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Data record, @Param("example") DataExample example);

    @UpdateProvider(type=DataSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Data record, @Param("example") DataExample example);

    @UpdateProvider(type=DataSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Data record);

    @Update({
        "update data",
        "set data = #{data,jdbcType=DECIMAL}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Data record);
}