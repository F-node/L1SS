/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lss;

/**
 *
 * @author user
 */
public class FSCalclator {

//    static double step = 0.001;//1ƒ~ƒŠ•b‚İ
//    static double calc_time = 1200;//20•ª

    /**
     *
     * @param fs_delay FSüŠú
     * @param speed ’ÊíUŒ‚‘¬“x
     * @return FSg—p‚ÌUŒ‚‘¬“x[/min]
     */
    static double calc(double fs_delay, double speed) {

        return 60.0 / fs_delay * (5.0 / 3.0 + fs_delay * speed / 60.0);

//        System.out.println("d"+fs_delay);
//        System.out.println("s"+speed);
//        if(speed == 0.0) {
//            return 0.0;
//        }
//
//        double atk_speed = 60 / speed;//1‰ñ‚ÌUŒ‚ŠÔ[sec]
//        
//        double time = 0.0;
//        int cnt_atk = 0;
//        int cnt_fs = 0;
//        int fs = 0;
//        double next_atk_time = 0.0;
//
//        while (time <= calc_time) {
//            
//            
//            
//            
//            
//            
////            if (time >= cnt_fs * fs_delay) {
////                fs = 3;
////                cnt_fs++;
////            }
////            if (next_atk_time <= 0.0) {
////                next_atk_time += atk_speed;
////                cnt_atk++;
////                fs--;
////            }
////            if (fs > 0) {
////                next_atk_time -= step * 3;
////            } else {
////                next_atk_time -= step;
////            }
//
//            time += step;
//        }
//        System.out.println("t"+time);
//        System.out.println("n"+cnt_atk);
//
//        return cnt_atk / calc_time * 60.0;
    }
}
