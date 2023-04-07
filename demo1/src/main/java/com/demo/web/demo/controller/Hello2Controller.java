package com.demo.web.demo.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.demo.web.demo.service.DemoService;
import com.response.ServiceResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;

@RestController
@RequestMapping("/web2")
public class Hello2Controller {
    private static final Logger logger = LoggerFactory.getLogger(Hello2Controller.class);

    @Autowired
    public DemoService demoService;

    @RequestMapping(value = "/demo", method = RequestMethod.POST)
    public ServiceResult demo() {
        logger.info("web2/demo");
        logger.warn("123213");
        return null;
    }

    @RequestMapping(value = "/mybatis01", method = RequestMethod.POST)
    public ServiceResult post01(@RequestBody HashMap<String, String> json) {
        ServiceResult byid = demoService.findByid("1");
        return byid;
    }

    /**
     * 下载模版
     *
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/downDemoExcel", method = RequestMethod.GET)
    @ResponseBody
    public void downExcel(HttpServletResponse response, @RequestParam("lx") String lx) throws Exception {
        System.out.println("lx==" + lx);
        String filename = "", name = "";
        switch (lx) {
            case "DD":
                filename = "demo1.xlsx";
                name = "模板1.xlsx";
                break;
            case "FP":
                filename = "demo2.xlsx";
                name = "模板2.xlsx";
                break;
        }
        if (!StringUtils.isBlank(filename)) {
            URL resourceurl = new ClassPathResource("static/xls/" + filename).getURL();
            //URL resourceurl = Thread.currentThread().getContextClassLoader().getResource(filename);
            fileDownload(response, resourceurl, name);
        }

    }

    /**
     * @param response
     * @param filePath//文件完整路径(包括文件名和扩展名)
     * @param fileName//下载后看到的文件名
     * @return 文件名
     */
    public static void fileDownload(final HttpServletResponse response, URL filePath, String fileName) throws Exception {

        byte[] data = toByteArray2(filePath);
        fileName = URLEncoder.encode(fileName, "UTF-8");
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream;charset=UTF-8");
        OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
        outputStream.write(data);
        outputStream.flush();
        outputStream.close();
        response.flushBuffer();
    }

    /**
     * 读取到字节数组2
     *
     * @param filePath
     * @return
     * @throws IOException
     */
    public static byte[] toByteArray2(URL filePath) throws IOException {

        File f = new File(filePath.getFile());
        if (!f.exists()) {
            throw new FileNotFoundException(filePath.toString());
        }
        FileChannel channel = null;
        FileInputStream fs = null;
        try {
            fs = new FileInputStream(f);
            channel = fs.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());
            while ((channel.read(byteBuffer)) > 0) {
            }
            return byteBuffer.array();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
