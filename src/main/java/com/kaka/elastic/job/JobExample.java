package com.kaka.elastic.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author fuwei
 * @version V1.0
 * @Description: TODO(用一句话描述该文件做什么)
 * @date 2018/9/26 10:36
 */
@Service("jobExample")
public class JobExample implements SimpleJob {

  private static final Logger logger = LoggerFactory.getLogger(JobExample.class);

  public void doSomeThing() {
    System.out.println(String.format(new SimpleDateFormat("HH:mm:ss.SSSSSS").format(new Date())) + "I want to do someThing ...");
  }

  public void doAnotherThing() {
    System.out.println(String.format(new SimpleDateFormat("HH:mm:ss.SSSSSS").format(new Date())) + "I want to do anotherThing ...");
  }

  @Override
  public void execute(ShardingContext context) {
    switch (context.getJobName()) {
      case "jobExample-doSomeThing" :
        doSomeThing();
        break;
      case "jobExample-doAnotherThing" :
        doAnotherThing();
        break;
    }
  }
}
