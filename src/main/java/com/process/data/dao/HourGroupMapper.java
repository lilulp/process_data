package com.process.data.dao;

import com.process.data.pojo.HourGroup;
import com.process.data.pojo.HourGroupExample;
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

public interface HourGroupMapper {
    @SelectProvider(type=HourGroupSqlProvider.class, method="countByExample")
    long countByExample(HourGroupExample example);

    @DeleteProvider(type=HourGroupSqlProvider.class, method="deleteByExample")
    int deleteByExample(HourGroupExample example);

    @Delete({
        "delete from hour_group",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into hour_group (id, hour_data)",
        "values (#{id,jdbcType=INTEGER}, #{hourData,jdbcType=DECIMAL})"
    })
    int insert(HourGroup record);

    @InsertProvider(type=HourGroupSqlProvider.class, method="insertSelective")
    int insertSelective(HourGroup record);

    @SelectProvider(type=HourGroupSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="hour_data", property="hourData", jdbcType=JdbcType.DECIMAL)
    })
    List<HourGroup> selectByExample(HourGroupExample example);

    @Select({
        "select",
        "id, hour_data",
        "from hour_group",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="hour_data", property="hourData", jdbcType=JdbcType.DECIMAL)
    })
    HourGroup selectByPrimaryKey(Integer id);

    @UpdateProvider(type=HourGroupSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") HourGroup record, @Param("example") HourGroupExample example);

    @UpdateProvider(type=HourGroupSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") HourGroup record, @Param("example") HourGroupExample example);

    @UpdateProvider(type=HourGroupSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(HourGroup record);

    @Update({
        "update hour_group",
        "set hour_data = #{hourData,jdbcType=DECIMAL}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(HourGroup record);

    @Insert("insert into hour_group (hour_data) values ${str}")
    void insertBatch(@Param("str") String hour_str);
}