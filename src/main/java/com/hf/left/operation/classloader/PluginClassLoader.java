package com.hf.left.operation.classloader;


import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/8/27 14:34
 * @version: 1.0
 */
public class PluginClassLoader extends URLClassLoader {

    public PluginClassLoader(URL[] urls) {
        super(urls);
    }

    public static void main(String[] args) {

        try {
            File pluginJar = new File("path/to/plugin.jar");
            URL[] urls = new URL[]{ pluginJar.toURI().toURL() };
            PluginClassLoader loader = new PluginClassLoader(urls);
            // 加载插件类
            Class<?> pluginClass = loader.loadClass("com.hf.left.operation.classloader.SoutPlugin");
            // 创建插件实例
            Plugin plugin = (Plugin) pluginClass.getDeclaredConstructor().newInstance();
            // 执行插件功能
            plugin.execute();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
