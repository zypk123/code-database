package com.zhang.utils;

import org.apache.curator.framework.recipes.locks.InterProcessLock;
import org.apache.zookeeper.data.ACL;

/**
 * zookeeper客户端 测试
 */
public class ZkClientUtils {

    private static ZkClient zkClient;

    public static ZkClient getZkClient(String zkAddr, int timeOut, String namespace, ACL acl) throws Exception {
        if (null != zkClient) {
            return zkClient;
        }
        synchronized (ZkClientUtils.class) {
            if (null != zkClient) {
                return zkClient;
            }
            zkClient = new ZkClient(zkAddr, timeOut, namespace, acl);
        }
        return zkClient;
    }


    /*******************************************************************************************/
    public static String address = "ip:29181";

    public static void main(String args[]) {

        //testDistributeLock();
        testCreateNode();
    }


    public static void testAcl() {

    }

    public static void testCreateNode() {
        try {
            ZkClient zkClient = ZkClientUtils.getZkClient(address, 30, "ns", null);
            zkClient.createPersitentNode("/test/qaz/t2/t/t", "data", true);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static void testDeleteNode() {

    }

    public static void testSetData() {

    }

    public static void testGetChildren() {

    }

    public static void testGetData() {

    }

    public static void testDistributeLock() {

        for (int i = 0; i < 50; i++) {
            new Thread() {

                @Override
                public void run() {
                    InterProcessLock lock = null;
                    try {
                        ZkClient zkClient = ZkClientUtils.getZkClient(address, 30, "dislock", null);
                        lock = zkClient.getInterProcessLock("/distributeLock");
                        System.out.println(Thread.currentThread().getName() + "申请锁");
                        lock.acquire();
                        System.out.println(Thread.currentThread().getName() + "持有锁");
                        Thread.sleep(500);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        if (null != lock) {
                            try {
                                lock.release();
                                System.out.println(Thread.currentThread().getName() + "释放有锁");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }

            }.start();

        }
    }
}