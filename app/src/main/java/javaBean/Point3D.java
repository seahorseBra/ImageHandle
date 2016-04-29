package javaBean;

import android.content.Intent;

/**
 * Created by zchao on 2016/3/10.
 */
public class Point3D extends Print {
    private int z;

    public Point3D(){}

    public double caculateVolume() {
        if (z != 0) {
            return getLineLenth() * Math.abs(z);
        }else {
            try {
                throw new Throwable("z must not zero");
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
        return 0;
    }
    public void setZ(int z) {
        this.z = z;
    }

    public int getZ() {
        return z;
    }

    @Override
    public String toString() {
        return super.toString() + "z = " + z;
    }
}
