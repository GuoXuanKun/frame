package com.gmgx.service.impl;

import com.gmgx.dao.IUserDao;
import com.gmgx.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
   private IUserDao iUserDao;


    /**
     *  @param deductionId 扣款人id
     * @param collectId   收款人id
     * @param money       金额
     * @return
     */
    @Override
    @Transactional  // import javax.transaction.Transactional;
    //当方法中，有涉及到 数据库的增删改，并且有其他操作（其他代码），为保证动作的一致性，可以加上事务注解
    public boolean transferAccounts(Integer deductionId, Integer collectId,  double money) {


       try {
           // 扣钱
           boolean flag1  =    iUserDao.modifyMoney(deductionId,-money);

           System.out.println(flag1);

          // System.out.println(1/0);  // 如果涉及到异常（在没捕获的情况下），事务启动 回滚机制

           //加钱
           boolean flag2  =    iUserDao.modifyMoney(collectId,money);
           System.out.println(flag2);
           // 自定义回滚的条件（另一个操作失败的情况下，前面的操作都要混滚）
           if(!flag2){
               // 如果 价钱 失败了，就回滚（撤回 前面  扣钱的动作）
               TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
           }


       }catch (Exception e){
           e.printStackTrace();
           // 注意：如果异常在方法已经捕获了，对于事务 来说，你已经处理，我就不需要回滚
           // 手动 实现 事务回滚
           TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
       }

        System.out.println("后续代码...");


        return true;
    }
}
