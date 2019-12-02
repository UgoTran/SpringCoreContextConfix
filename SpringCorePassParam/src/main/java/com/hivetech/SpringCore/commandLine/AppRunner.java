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

        context.getEnvironment().getPropertySources().addFirst(theSource);

        DBInfo info = context.getBean(com.hivetech.SpringCore.commandLine.DBInfo.class);
        info.getParam();
//        mvn -q clean compile exec:java -Dexec.mainClass="com.hivetech.SpringCore.commandLine.AppRunner" -Dexec.args="--db.url=testval1 --db.port=testVal2 --db.user=testval3 --db.pass=testval4"
        System.out.println(info);
    }
}
