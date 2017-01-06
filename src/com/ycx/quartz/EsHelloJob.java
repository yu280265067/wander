package com.ycx.quartz;

import com.dangdang.ddframe.job.api.ElasticJob;
import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

import java.util.Date;

/**
 * Created by yuchengxiang on 16/12/6.
 */
public class EsHelloJob implements SimpleJob {

    @Override
    public void execute(ShardingContext shardingContext) {
        {
            switch (shardingContext.getShardingItem()) {
                case 0:
                    // do something by sharding item 0
                    System.out.println("elastic job  000");
                    System.out.println(new Date());
                    break;
                /*case 1:
                    // do something by sharding item 1
                    System.out.println("elastic job  111");
                    System.out.println(new Date());
                    break;
                case 2:
                    // do something by sharding item 2
                    System.out.println("elastic job  222");
                    System.out.println(new Date());
                    break;*/
                // case n: ...
            }
        }
    }
}
