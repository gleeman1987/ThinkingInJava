package chapter18javaio;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * OkLine(Hangzhou) Co,ltd
 * Created by zhengjun
 * Date: 2017/11/14
 * Mail:zhengjun1987@outlook.com
 */
public final class Directory {
    public static File[] local(File dir,String regex){
        return dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return Pattern.compile(regex).matcher(new File(name).getName()).matches();
            }
        });
    }

    public static File[] local(String path,String regex){
        return local(new File(path),regex);
    }

    public static class TreeInfo implements Iterable<File>{
        public List<File> files = new ArrayList<>();
        public List<File> dirs = new ArrayList<>();
        @Override
        public Iterator<File> iterator() {
            return files.iterator();
        }

        public void addAll(TreeInfo treeInfo){
            files.addAll(treeInfo.files);
            dirs.addAll(treeInfo.dirs);
        }

        @Override
        public String toString() {
            return
                    "files=" + PPrint.pformat(files) +
                    "\ndirs=" + PPrint.pformat(dirs) +
                    '}';
        }
    }

    public static TreeInfo walk(File start,String regex){
        return recurseDirs(start,regex);
    }

    public static TreeInfo walk(String start,String regex){
        return walk(new File(start),regex);
    }

    public static TreeInfo walk(File start){
        return recurseDirs(start,".*");
    }

    public static TreeInfo walk(String start){
        return walk(new File(start));
    }

    static TreeInfo recurseDirs(File startDir,String regex){
        TreeInfo result = new TreeInfo();
        for (File file : startDir.listFiles()) {
            if (file.isDirectory()) {
                result.dirs.add(file);
                result.addAll(recurseDirs(file,regex));
            } else {
                if (file.getName().matches(regex)) {
                    result.files.add(file);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(walk("."));
    }
}
