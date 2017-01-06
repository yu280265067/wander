package com.ycx.aop;

import com.ycx.annotation.Action;
import com.ycx.annotation.Push;
import com.ycx.annotation.PushType;
import com.ycx.annotation.ValueType;
import org.springframework.stereotype.Component;

/**
 * Created by yuchengxiang on 16/12/9.
 */
@Component
public class PushServiceImpl {
    @Push(value = "#bankAccount.getMemberId()+ ':' +#bankAccount.getBankcardId()", valueType = ValueType.MemberId,pushType = PushType.CARD,action = Action.REMOVE)
    public String sayHelloAopTest(BankAccount bankAccount){
        System.out.println("注解AOP");
        return bankAccount.getMemberId();
    }

    public String sayHelloAopTest(){
        System.out.println("注解AOP");
        return "1123";
    }
}
