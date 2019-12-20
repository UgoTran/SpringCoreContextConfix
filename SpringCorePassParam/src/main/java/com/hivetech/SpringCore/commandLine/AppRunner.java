package com.hivetech.SpringCore.commandLine;

import com.hivetech.SpringCore.preConfig.annotationConfig.SpringAppContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.SimpleCommandLinePropertySource;

public class AppRunner {
    public static void main(String[] args) {
        PropertySource theSource = new SimpleCommandLinePropertySource(args);

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringAppCmdContext.class);

        context.getEnvironment().getPropertySources().addLast(theSource);

        DBInfo info = context.getBean(com.hivetech.SpringCore.commandLine.DBInfo.class);
        info.getParam();
//        mvn -q clean compile exec:java -Dexec.mainClass="com.hivetech.SpringCore.commandLine.AppRunner" -Dexec.args="--db.url=testval1 --db.port=testVal2 --db.user=testval3 --db.pass=testval4"
        System.out.println(info);
    }
    //    "C:\Program Files\Java\jdk-11.0.5\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2019.2.4\lib\idea_rt.jar=52241:C:\Program Files\JetBrains\IntelliJ IDEA 2019.2.4\bin" -Dfile.encoding=UTF-8 -classpath D:\project_git\SpringCoreContextConfix\SpringCorePassParam\target\classes;C:\Users\thanh\.m2\repository\org\springframework\spring-context\5.2.0.RELEASE\spring-context-5.2.0.RELEASE.jar;C:\Users\thanh\.m2\repository\org\springframework\spring-aop\5.2.0.RELEASE\spring-aop-5.2.0.RELEASE.jar;C:\Users\thanh\.m2\repository\org\springframework\spring-beans\5.2.0.RELEASE\spring-beans-5.2.0.RELEASE.jar;C:\Users\thanh\.m2\repository\org\springframework\spring-core\5.2.0.RELEASE\spring-core-5.2.0.RELEASE.jar;C:\Users\thanh\.m2\repository\org\springframework\spring-jcl\5.2.0.RELEASE\spring-jcl-5.2.0.RELEASE.jar;C:\Users\thanh\.m2\repository\org\springframework\spring-expression\5.2.0.RELEASE\spring-expression-5.2.0.RELEASE.jar com.hivetech.SpringCore.commandLine.AppRunner "-Dexec.args=--db.url=testval1 --db.port=testVal2 --db.user=testval3 --db.pass=testval4"
//"C:\Program Files\Java\jdk-11.0.5\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2019.2.4\lib\idea_rt.jar=52296:C:\Program Files\JetBrains\IntelliJ IDEA 2019.2.4\bin" -Dfile.encoding=UTF-8 -classpath D:\project_git\SpringCoreContextConfix\SpringCorePassParam\target\classes;C:\Users\thanh\.m2\repository\org\springframework\spring-context\5.2.0.RELEASE\spring-context-5.2.0.RELEASE.jar;C:\Users\thanh\.m2\repository\org\springframework\spring-aop\5.2.0.RELEASE\spring-aop-5.2.0.RELEASE.jar;C:\Users\thanh\.m2\repository\org\springframework\spring-beans\5.2.0.RELEASE\spring-beans-5.2.0.RELEASE.jar;C:\Users\thanh\.m2\repository\org\springframework\spring-core\5.2.0.RELEASE\spring-core-5.2.0.RELEASE.jar;C:\Users\thanh\.m2\repository\org\springframework\spring-jcl\5.2.0.RELEASE\spring-jcl-5.2.0.RELEASE.jar;C:\Users\thanh\.m2\repository\org\springframework\spring-expression\5.2.0.RELEASE\spring-expression-5.2.0.RELEASE.jar com.hivetech.SpringCore.commandLine.AppRunner --db.url=testval1 --db.port=testVal2 --db.user=testval3 --db.pass=testval4

}
