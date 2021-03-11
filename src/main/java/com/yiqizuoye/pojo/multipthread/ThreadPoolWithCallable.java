package com.yiqizuoye.pojo.multipthread;

//import com.cedarsoftware.util.ExceptionUtilities;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * Author: kang.liu
 * Date  : 2018/8/22 20:15
 * Description:
 *
 * @author ll
 */
public class ThreadPoolWithCallable {
    private static final Logger logger = LoggerFactory.getLogger(ThreadPoolWithCallable.class);

    public static void main(String[] args) throws InterruptedException {
        // 调用方法
        ThreadPoolWithCallable threadPoolWithcallable = new ThreadPoolWithCallable();
        List<Future<String>> stringList = threadPoolWithcallable.execuateTask();
        stringList.forEach(future -> {
            if (!future.isCancelled()) {
                String s = null;
                try {
                    s = future.get();
                } catch (Exception e) {
                }
                System.out.println(s);
            }
        });
    }

    private List<Future<String>> execuateTask() throws InterruptedException {
        //        创建线程池
        //        提交任务
        List<Future<String>> futures = null;
        List<ComputerTask> computerTasks = Lists.newArrayList();
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
//        try {
//            for (int i = 0; i < 10; i++) {
//                Future<String> result = executorService.submit(new ComputerTask());
//                futures.add(result);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            executorService.shutdown();
//        }
        // 添加任务
        for (int i = 0; i < 10; i++) {
            computerTasks.add(new ComputerTask());
        }
        try {
            // 批量处理任务集合
            futures = executorService.invokeAll(computerTasks, 3000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (executorService != null) {
                try {
                    executorService.shutdownNow();
                } catch (Exception ex) {
//                    ExceptionUtilities.safelyIgnoreException(ex);
                }
            }
        }
        return futures;
    }

}

/**
 * 单核任务
 */
class ComputerTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        return UUID.randomUUID().toString().replace("-", "");
    }
}


   /* private QueryContractTemplateResponse convertQueryContractTemplateResponse(List<ContractTemplate> contractTemplateList) {
        if (CollectionUtils.isEmpty(contractTemplateList)) {
            return new QueryContractTemplateResponse(true, RespCodeEnum.SUCCESS.getCode(), RespCodeEnum.SUCCESS.getDesc(), null);
        }

        class ContractTemplateTask implements Callable<Map<Long,Integer>>{
            private Long id;
            private String contractTemplateNo;
            private String contractTemplateVersion;
            public Long getId() {
                return id;
            }
            public void setId(Long id) {
                this.id = id;
            }
            public String getContractTemplateNo() {
                return contractTemplateNo;
            }
            public void setContractTemplateNo(String contractTemplateNo) {
                this.contractTemplateNo = contractTemplateNo;
            }
            public String getContractTemplateVersion() {
                return contractTemplateVersion;
            }
            public void setContractTemplateVersion(String contractTemplateVersion) {
                this.contractTemplateVersion = contractTemplateVersion;
            }

            public ContractTemplateTask(Long id, String contractTemplateNo, String contractTemplateVersion) {
                this.id = id;
                this.contractTemplateNo = contractTemplateNo;
                this.contractTemplateVersion = contractTemplateVersion;
            }


            @Override
            public Map<Long, Integer> call() throws Exception {
                Map<Long, Integer> result = new HashMap<>();
                List<AccountContract> accountContracts = contractTemplateService.queryAccountContractByTemplateId(this.getContractTemplateNo(), this.getContractTemplateVersion(), this.getId());
                if (CollectionUtils.isEmpty(accountContracts)) {
                    result.put(getId(), 0);
                } else {
                    result.put(getId(), accountContracts.size());
                }
                return result;
            }
        }

        Map<Long, Integer> templateISignMap = new HashMap<>();



        ExecutorService executorService = null;

        List<ContractTemplateTask> templateTasks = Lists.transform(contractTemplateList, contractTemplate -> {
            return new ContractTemplateTask(contractTemplate.getId(),contractTemplate.getContractTemplateNo(),contractTemplate.getContractTemplateVersion());
        });
        try {
            executorService = Executors.newFixedThreadPool(50);
            List<Future<Map<Long, Integer>>> futures = null;
            try {
                futures = executorService.invokeAll(templateTasks);
            } catch (Exception e) {
                logger.error(" future executor exception: {}", e.getMessage());
            }
            if (futures != null) {
                for (Future<Map<Long,Integer>> future : futures) {
                    try {
                        if (!future.isCancelled()) {
                            if (future.get() != null) {
                                templateISignMap.putAll(future.get());
                            }
                        } else {
                            logger.warn(" thread was cancelled");
                        }
                    } catch (Exception e) {
                        logger.error(" thread exception: {}", e);
                    }
                }
            }

        } finally {
            // 关闭资源
            if (executorService != null) {
                try {
                    executorService.shutdownNow();
                } catch (Exception ex) {
                    logger.error(" future executor exception: {}", ex.getMessage());
                }
            }
        }
       */

        /*List<ContractTemplateVo> contractTemplateVos = Lists.transform(contractTemplateList, contractTemplate -> {
            ContractTemplateVo contractTemplateVo = new ContractTemplateVo();
            BeanUtils.copyProperties(contractTemplate, contractTemplateVo);
            contractTemplateVo.setSignedNum(templateISignMap.get(contractTemplate.getId()));
            return contractTemplateVo;
        });
        return new QueryContractTemplateResponse(true, RespCodeEnum.SUCCESS.getCode(), RespCodeEnum.SUCCESS.getDesc(), contractTemplateVos);
    }*/