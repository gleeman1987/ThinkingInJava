package chapter02oop;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/15
 * Mail:zhengjun1987@outlook.com
 */
public class ShowProperties {
    public static void main(String[] args) {
        System.getProperties().list(System.out);
//        -- listing properties --
//        java.runtime.name=Java(TM) SE Runtime Environment
//        sun.boot.library.path=/Library/Java/JavaVirtualMachines/jdk...
//        java.vm.version=25.40-b25
//        gopherProxySet=false
//        java.vm.vendor=Oracle Corporation
//        java.vendor.url=http://java.oracle.com/
//        path.separator=:
//        java.vm.name=Java HotSpot(TM) 64-Bit Server VM
//        file.encoding.pkg=sun.io
//        idea.launcher.port=7533
//        user.country=CN
//        sun.java.launcher=SUN_STANDARD
//        sun.os.patch.level=unknown
//        java.vm.specification.name=Java Virtual Machine Specification
//        user.dir=/Users/zhengjun/IdeaProjects/Thinking...
//        java.runtime.version=1.8.0_40-b27
//        java.awt.graphicsenv=sun.awt.CGraphicsEnvironment
//        java.endorsed.dirs=/Library/Java/JavaVirtualMachines/jdk...
//        os.arch=x86_64
//        java.io.tmpdir=/var/folders/kh/w63l1td955d1s0t6dqs0m...
//        line.separator=
//
//                java.vm.specification.vendor=Oracle Corporation
//        os.name=Mac OS X
//        sun.jnu.encoding=UTF-8
//        java.library.path=/Users/zhengjun/Library/Java/Extensio...
//        java.specification.name=Java Platform API Specification
//        java.class.version=52.0
//        sun.management.compiler=HotSpot 64-Bit Tiered Compilers
//        os.version=10.12.6
//        http.nonProxyHosts=local|*.local|169.254/16|*.169.254/16
//        user.home=/Users/zhengjun
//        user.timezone=Asia/Shanghai
//        java.awt.printerjob=sun.lwawt.macosx.CPrinterJob
//        java.specification.version=1.8
//        file.encoding=UTF-8
//        idea.launcher.bin.path=/Applications/IntelliJ IDEA 15.app/Co...
//        user.name=zhengjun
//        java.class.path=/Library/Java/JavaVirtualMachines/jdk...
//        java.vm.specification.version=1.8
//        sun.arch.data.model=64
//        java.home=/Library/Java/JavaVirtualMachines/jdk...
//        sun.java.command=com.intellij.rt.execution.application...
//        java.specification.vendor=Oracle Corporation
//        user.language=zh
//        awt.toolkit=sun.lwawt.macosx.LWCToolkit
//        java.vm.info=mixed mode
//        java.version=1.8.0_40
//        java.ext.dirs=/Users/zhengjun/Library/Java/Extensio...
//        sun.boot.class.path=/Library/Java/JavaVirtualMachines/jdk...
//        java.vendor=Oracle Corporation
//        file.separator=/
//        java.vendor.url.bug=http://bugreport.sun.com/bugreport/
//        sun.cpu.endian=little
//        sun.io.unicode.encoding=UnicodeBig
//        socksNonProxyHosts=local|*.local|169.254/16|*.169.254/16
//        ftp.nonProxyHosts=local|*.local|169.254/16|*.169.254/16
//        sun.cpu.isalist=

        System.out.println("System.getProperty(\"user.name\") = " + System.getProperty("user.name"));
//        System.getProperty("user.name") = zhengjun

        System.out.println("System.getProperty(\"java.library.path\") = " + System.getProperty("java.library.path"));
//        System.getProperty("java.library.path") = /Users/zhengjun/Library/Java/Extensions:/Library/Java/Extensions:/Network/Library/Java/Extensions:/System/Library/Java/Extensions:/usr/lib/java:.
    }
}
