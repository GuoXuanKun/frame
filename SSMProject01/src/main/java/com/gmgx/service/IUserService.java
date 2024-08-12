package com.gmgx.service;

public interface IUserService {


    /**
     *
     *   @param deductionId 扣款人id
        * @param collectId 收款人id

     * @param money 金额
     * @return
     */
    public boolean transferAccounts(Integer deductionId, Integer collectId, double money);


}
