package com.sun.utils;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * @author Eric
 * @description
 * @date 2024/3/1 11:58
 **/
@Slf4j
public class TaxAction {

    /**
     * 起征点
     */
    private static BigDecimal THRESHOLD = new BigDecimal(5000);

    /**
     *
     * @param salary
     *            税前薪水
     * @param socialSecurity
     *            个人减扣部分 如五险一金
     * @param num 六项扣减 如
     * @return 实际所得收入
     */
    public static BigDecimal getPayload(BigDecimal salary, BigDecimal socialSecurity, BigDecimal num) {
        socialSecurity = socialSecurity.setScale(2, BigDecimal.ROUND_HALF_UP);
        salary = salary.setScale(2, BigDecimal.ROUND_HALF_UP);
        log.info("您的税前收入为：{}元， 个人缴纳五险一金为{}元，六项扣减额为{}元", salary, socialSecurity,num);
        BigDecimal income = salary.subtract(socialSecurity);// 税前薪水（扣除五险一金部分）
        BigDecimal tax = new BigDecimal(0);// 实缴个税
        BigDecimal paload = income.subtract(THRESHOLD);// 应纳税所得额
        if (num != null) {
            paload = paload.subtract(num);
        }
        BigDecimal total = new BigDecimal(0);// 实际所得
        if (paload.compareTo(new BigDecimal(0)) > 0) {

            if (paload.compareTo(new BigDecimal(3000)) <= 0) {
                tax = paload.multiply(new BigDecimal(0.03));
            } else if (paload.compareTo(new BigDecimal(12000)) <= 0) {
                tax = (paload.subtract(new BigDecimal(3000))).multiply(new BigDecimal(0.1)).add(new BigDecimal(90));
            } else if (paload.compareTo(new BigDecimal(25000)) <= 0) {
                tax = (paload.subtract(new BigDecimal(12000))).multiply(new BigDecimal(0.2)).add(new BigDecimal(900))
                        .add(new BigDecimal(90));
            } else if (paload.compareTo(new BigDecimal(35000)) <= 0) {
                tax = (paload.subtract(new BigDecimal(25000))).multiply(new BigDecimal(0.25)).add(new BigDecimal(2600))
                        .add(new BigDecimal(900)).add(new BigDecimal(90));
            } else if (paload.compareTo(new BigDecimal(55000)) <= 0) {
                tax = (paload.subtract(new BigDecimal(35000))).multiply(new BigDecimal(0.3)).add(new BigDecimal(2500))
                        .add(new BigDecimal(2600)).add(new BigDecimal(900)).add(new BigDecimal(90));
            } else if (paload.compareTo(new BigDecimal(80000)) <= 0) {
                tax = (paload.subtract(new BigDecimal(55000))).multiply(new BigDecimal(0.35)).add(new BigDecimal(6000))
                        .add(new BigDecimal(2500)).add(new BigDecimal(2600)).add(new BigDecimal(900))
                        .add(new BigDecimal(90));
            } else {
                tax = (paload.subtract(new BigDecimal(80000))).multiply(new BigDecimal(0.45)).add(new BigDecimal(12250))
                        .add(new BigDecimal(6000)).add(new BigDecimal(2500)).add(new BigDecimal(2600))
                        .add(new BigDecimal(900)).add(new BigDecimal(90));
            }
        }
        // 四舍五入取2位小数
        tax = tax.setScale(2, BigDecimal.ROUND_HALF_UP);
        log.info("您应缴纳个税为：{}元", tax);
        total = income.subtract(tax);
        log.info("您实际所得为：{}元", total);
        return total;

    }

    public static void main(String[] args) {
        //税前月薪
        BigDecimal salary = new BigDecimal(183283);
        //五险一金个人 缴纳部分
        BigDecimal socialSecurity = new BigDecimal(23872);
        // 个税6项扣减 月累计免征额度
        BigDecimal num = new BigDecimal(36000);
        getPayload(salary, socialSecurity, num);
    }
}
