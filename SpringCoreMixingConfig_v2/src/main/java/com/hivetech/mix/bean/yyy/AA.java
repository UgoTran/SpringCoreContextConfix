package com.hivetech.mix.bean.yyy;

import com.hivetech.mix.bean.xxx.BB;
import com.hivetech.mix.bean.xxx.CC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AA {
    private BB instantBB;
    private CC instantCC;

    public AA() {
        System.out.println("Creating bean AA " + this);
    }

    @Autowired
    public void setinstantBB(BB instantBB) {
        System.out.println("Setting AA.instantBB with " + instantBB);
        this.instantBB = instantBB;
    }

    @Autowired
    public void setinstantCC(CC instantCC) {
        System.out.println("Setting AA.instantCC with " + instantCC);
        this.instantCC = instantCC;
    }
}
