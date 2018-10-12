package com.process.data.dao;

import com.process.data.pojo.FiveGroup;
import com.process.data.pojo.FiveGroupExample;
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

public interface FiveGroupMapper {
    @SelectProvider(type=FiveGroupSqlProvider.class, method="countByExample")
    long countByExample(FiveGroupExample example);

    @DeleteProvider(type=FiveGroupSqlProvider.class, method="deleteByExample")
    int deleteByExample(FiveGroupExample example);

    @Delete({
        "delete from five_group",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into five_group (id, five_data)",
        "values (#{id,jdbcType=INTEGER}, #{fiveData,jdbcType=DECIMAL})"
    })
    int insert(FiveGroup record);

    @InsertProvider(type=FiveGroupSqlProvider.class, method="insertSelective")
    int insertSelective(FiveGroup record);

    @SelectProvider(type=FiveGroupSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="five_data", property="fiveData", jdbcType=JdbcType.DECIMAL)
    })
    List<FiveGroup> selectByExample(FiveGroupExample example);

    @Select({
        "select",
        "id, five_data",
        "from five_group",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="five_data", property="fiveData", jdbcType=JdbcType.DECIMAL)
    })
    FiveGroup selectByPrimaryKey(Integer id);

    @UpdateProvider(type=FiveGroupSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") FiveGroup record, @Param("example") FiveGroupExample example);

    @UpdateProvider(type=FiveGroupSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") FiveGroup record, @Param("example") FiveGroupExample example);

    @UpdateProvider(type=FiveGroupSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(FiveGroup record);

    @Update({
        "update five_group",
        "set five_data = #{fiveData,jdbcType=DECIMAL}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(FiveGroup record);

    @Insert("insert into five_group (five_data) values ${str}")
    void insertBatch(@Param("str") String five_str);
}