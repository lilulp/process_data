package com.process.data.service.impl;

import com.process.data.dao.DataMapper;
import com.process.data.dao.FiveGroupMapper;
import com.process.data.dao.HourGroupMapper;
import com.process.data.pojo.*;
import com.process.data.service.BaseDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class BaseDataServiceImpl implements BaseDataService{
    @Autowired
    private DataMapper dataMapper;

    @Autowired
    private FiveGroupMapper fiveGroupMapper;

    @Autowired
    private HourGroupMapper hourGroupMapper;


    /**
     * 计算
     */
    @Override
    public void updateGroup() {
        //获取一共有多少条基础数据
        DataExample example = new DataExample();
        long l = dataMapper.countByExample(example);
        System.out.println(l);
        //查询出每一条数据
        List<Data> data = dataMapper.selectByExample(example);
        //2400一组
        int five_groups = (int)l / 2400;
        //3600 * 8 =28800 个一组
        int hour_groups = (int)l / 28800;
        //循环遍历取出来的数值，2400一组
        List<BigDecimal> five_data = new ArrayList<>();
        for(int i=0;i<five_groups;i++){
            BigDecimal data1 = data.get(i * 2400).getData();
            BigDecimal data2 = data.get((i + 1) * 2400 - 1).getData();
            //计算2400一组的差值
            BigDecimal chazhi = data2.subtract(data1).multiply(new BigDecimal(2));
            five_data.add(chazhi);
        }
        System.out.println("2400=========="+five_data);
        //循环遍历取出来的数值28800一组
        List<BigDecimal> hour_data = new ArrayList<>();
        for(int i=0;i<hour_groups;i++){
            BigDecimal data1 = data.get(i * 28800).getData();
            BigDecimal data2 = data.get((i + 1) * 28800 - 1).getData();
            //计算28800一组的差值
            BigDecimal multiply = data2.subtract(data1).divide(new BigDecimal(6),4,BigDecimal.ROUND_HALF_UP);
            hour_data.add(multiply);
        }
        System.out.println("28800==============="+hour_data);
        String five_str = insertObj(five_data);
        fiveGroupMapper.insertBatch(five_str);
        String hour_str = insertObj(hour_data);
        hourGroupMapper.insertBatch(hour_str);

    }


    public String insertObj(List<BigDecimal> list){
        String str = "";
        for(int i=0;i<list.size();i++){
            str += "("+list.get(i)+ ")";
            if(i!=list.size()-1){
                str += ",";
            }
        }
        return str;
    }

}
