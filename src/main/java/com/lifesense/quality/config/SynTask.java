package com.lifesense.quality.config;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 赵春定 on 2017/10/17.
 */
@Component
public class SynTask {

    private final static String REQUEST_URL = "http://device-sn.lifesense.com/pms/sn/get_po_info";
    private final static String ACCESS_TOKEN = "accessToken=b85faeaa4a24487c95f426be02c25b6b";
  /*  @Autowired
    private SheetService sheetService;
    @Autowired
    private ProductService productService;
    @Autowired
    private SnowflakeIdWorker worker;

    @Scheduled(fixedRate = 1800000)
    public void synSheet() {
        WorkSheet sheet = new WorkSheet();
        sheet.setValid(1);
        List<WorkSheet> listSheet = sheetService.getPageData(1, 10, sheet);
        if (listSheet.size() > 0) {
            for (WorkSheet item : listSheet) {
                String sheetNo = item.getSheetNo();
                if (item.getType() == 0) {
                    String result = synSheet(sheetNo);
                    processResult(item, result);
                } else {
                    autoCreate(item);
                }
            }
        }

    }

    @Transactional(rollbackFor = java.sql.SQLException.class)
    private void autoCreate(WorkSheet sheet) {
        List<Product> list = new ArrayList<Product>();
        String po = sheet.getSheetNo();
        int num = sheet.getOutputNum();
        sheet.setStartTime(new Date());
        sheet.setValid(0);
        String prefix = po.toLowerCase().replaceFirst("po#", "");
        String temp = "0000000000";
        prefix = prefix + temp.substring(prefix.length());
        for (int i = 0; i < num; i++) {
            String sn = prefix + String.format("%06d", num + i + 1);
            Product product = new Product();
            product.setId(worker.nextId());
            product.setSn(sn);
            product.setSheetNo(po);
            product.setProductType(sheet.getProductType());
            product.setProcessResult(0);//未测试
            product.setRepair(0);//维修状态，0正常，1维修*//*
            product.setRepairNum(0);//维修次数
            list.add(product);
        }
        productService.batchSave(list);
        sheetService.updateWorkSheet(sheet);
    }
*/
    private String synSheet(String sheetNo) {
        StringBuilder result = new StringBuilder("");// 返回的结果
        BufferedReader in = null;// 读取响应输入流
        PrintWriter out = null;
        try {
            String context = "{\"po\":\"" + sheetNo + "\"}";
            URL url = new URL(REQUEST_URL + "?" + ACCESS_TOKEN);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept", "*/*");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("User-Agent",
                    "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)");
            conn.setRequestProperty("Charset", "UTF-8");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept-Charset", "UTF-8");
            // 设置POST方式
            conn.setDoInput(true);
            conn.setDoOutput(true);
            // 获取HttpURLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.write(context);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应，设置编码方式
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            // 读取返回的内容
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result.toString();
    }

/*

    @Transactional(rollbackFor = java.sql.SQLException.class)
    private void processResult(WorkSheet sheet, String result) {
        if (!StringUtils.isEmpty(result)) {
            JSONObject jsonObject = JSON.parseObject(result);
            Object code = jsonObject.get("code");
            if (!StringUtils.isEmpty(code) && "200".equals(code.toString())) {
                JSONObject data = jsonObject.getJSONObject("data");
                String po = data.getString("po");
                sheet.setProductTypeName(data.getString("productType"));
                sheet.setCreateUser(data.getString("creator"));
                sheet.setOutputNum(data.getIntValue("quantity"));
                sheet.setCreateTime(data.getDate("createTime"));
                sheet.setStartTime(data.getDate("approveTime"));
                sheet.setValid(0);
                JSONArray deviceSns = data.getJSONArray("deviceSns");
                List<Product> list = new ArrayList<Product>();
                System.out.println(po + "导入sn个数" + deviceSns.size());
                for (int i = 0; i < deviceSns.size(); i++) {
                    JSONObject obj = deviceSns.getJSONObject(i);
                    String sn = obj.getString("sn");
                    Product product = new Product();
                    product.setId(worker.nextId());
                    product.setSn(sn);
                    product.setSheetNo(po);
                    product.setProductType(sheet.getProductType());
                    product.setProcessResult(0);//未测试
                    product.setRepair(0);//维修状态，0正常，1维修*//*

                    product.setRepairNum(0);//维修次数
                    list.add(product);
                }
                productService.batchSave(list);
                sheetService.updateWorkSheet(sheet);
            }
        }
    }
*/


}
