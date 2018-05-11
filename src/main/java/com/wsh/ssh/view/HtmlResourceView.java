package com.wsh.ssh.view;

import org.springframework.web.servlet.view.InternalResourceView;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

public class HtmlResourceView extends InternalResourceView {
    @Override
    public boolean checkResource(Locale locale) throws IOException {
        //getUrl:      /WEB-INF/html/test_html.html
        System.out.println("getUrl:" + getUrl() + "realPath" + getWebApplicationContext().getResource(getUrl()).getFile().getAbsolutePath() + ">" + getWebApplicationContext().getResource(getUrl()).exists());

//        File file = new File(getServletContext().getRealPath("/")+getUrl());
//        return !file.exists();// 判断该页面是否存在
        return getWebApplicationContext().getResource(getUrl()).exists();
    }
}
