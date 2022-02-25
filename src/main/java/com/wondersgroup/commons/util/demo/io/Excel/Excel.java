package com.wondersgroup.commons.util.demo.io.Excel;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * TODO
 *唐俊林
 * @since
 */
public class Excel {

    /**
     * 1.创建工作簿
     * @throws IOException
     */
    @Test
    public  void test1() throws IOException {
        //创建工作簿 （使用了多态特性）    HSSFWorkbook wb = new HSSFWorkbook();
        Workbook wb = new HSSFWorkbook();
        //使用工作簿的write()方法向文件输出工作簿
        FileOutputStream out = new FileOutputStream("src/main/resources/demo/excel/1.xls");
        wb.write(out);
        //流的关闭
        out.close();
        System.out.printf("创建工作簿成功");
    }

    /**
     * 2.创建sheet页
     * @throws IOException
     */
    @Test
    public  void test2() throws IOException {
            //创建工作簿 （使用了多态特性）    HSSFWorkbook wb = new HSSFWorkbook();
            Workbook wb = new HSSFWorkbook();
            //创建两个sheet页
            wb.createSheet("sheet1");
            wb.createSheet("sheet2");
            //创建流并将wb输出
            FileOutputStream out = new FileOutputStream("src/main/resources/demo/excel/2.xls");
            wb.write(out);
            //流的关闭
            out.close();
        System.out.printf("创建sheet页成功");
        }

    /**
     * 3.创建行和单元格
     * @throws IOException
     */
    @Test
    public  void test3() throws IOException {
        //创建工作簿 （使用了多态特性）    HSSFWorkbook wb = new HSSFWorkbook();
        Workbook wb = new HSSFWorkbook();
        //创建sheet页（使用的是带参构造器）
        Sheet sheet = wb.createSheet("sheet01");
        //创建行（从0开始）
        Row row = sheet.createRow(0);
        //创建单元格(第一列)
        Cell cell = row.createCell(0);
        //给单元格赋值
        cell.setCellValue("测试单元格内容");
        //创建流并将wb输出
        FileOutputStream out = new FileOutputStream("src/main/resources/demo/excel/3.xls");
        wb.write(out);
        //流的关闭
        out.close();
        System.out.printf("创建行和单元格成功");
    }

    /**
     * 3.单元格创建其他值的示例
     * @throws IOException
     */
    @Test
    public  void test4() throws IOException {
        //创建工作簿 （使用了多态特性）    HSSFWorkbook wb = new HSSFWorkbook();
        Workbook wb = new HSSFWorkbook();
        //创建sheet页（使用的是带参构造器）
        Sheet sheet = wb.createSheet("sheet01");
        //创建行（从0开始）
        Row row = sheet.createRow(0);
        //创建单元格(第一列)
        Cell cell = row.createCell(0);
        //给单元格赋值
        cell.setCellValue("测试单元格内容");
        //测试其他的赋值方式
        row.createCell(1).setCellValue(1.1);    //第二列赋浮点值
        row.createCell(2).setCellValue(false);  //第三列赋值boolean型
        row.createCell(3).setCellValue("测试单元格内容11");  //
        //创建流并将wb输出
        FileOutputStream out = new FileOutputStream("src/main/resources/demo/excel/4.xls");
        wb.write(out);
        //流的关闭
        out.close();
        System.out.printf("单元格创建其他值的示例成功");
    }

    @Test
    public void demo() throws IOException {
        String date = "[{\"jisuanhou\":\"12039.2\",\"code\":\"91310120062572186T\",\"bqybtfe\":\"12039.1\"},{\"jisuanhou\":\"23258.4\",\"code\":\"91310230067805532T\",\"bqybtfe\":\"23258.4\"},{\"jisuanhou\":\"5236.7\",\"code\":\"913101131321608586\",\"bqybtfe\":\"55187.4\"},{\"jisuanhou\":\"0\",\"code\":\"91310120134070792P\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310117134103208C\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310120MA1HLXC723\",\"bqybtfe\":\"25631.6\"},{\"jisuanhou\":\"0\",\"code\":\"91310114741152028T\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"167177.7\",\"code\":\"91310000741179714Q\",\"bqybtfe\":\"231484\"},{\"jisuanhou\":\"194005.8\",\"code\":\"9131010413262558XA\",\"bqybtfe\":\"263427.9\"},{\"jisuanhou\":\"0\",\"code\":\"91310105737497736A\",\"bqybtfe\":\"50915.5\"},{\"jisuanhou\":\"0\",\"code\":\"11310110002448220M\",\"bqybtfe\":\"37867.2\"},{\"jisuanhou\":\"229516.9\",\"code\":\"91310112630419121M\",\"bqybtfe\":\"286109.3\"},{\"jisuanhou\":\"0\",\"code\":\"91310120MA1HUE380L\",\"bqybtfe\":\"3253\"},{\"jisuanhou\":\"14500.1\",\"code\":\"91310116MA1JDF075N\",\"bqybtfe\":\"14500.1\"},{\"jisuanhou\":\"0\",\"code\":\"91310118134319973J\",\"bqybtfe\":\"54142.8\"},{\"jisuanhou\":\"0\",\"code\":\"12310105E788243945\",\"bqybtfe\":\"29723\"},{\"jisuanhou\":\"0\",\"code\":\"91310113133495828C\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310230MA1JTA7J1B\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"52310105082046319F\",\"bqybtfe\":\"12903.8\"},{\"jisuanhou\":\"0\",\"code\":\"913101097914268327\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310104132231011G\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"913101127655526160\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310115575846613A\",\"bqybtfe\":\"116236.4\"},{\"jisuanhou\":\"0\",\"code\":\"91310120MA1HK12337\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310114795604376J\",\"bqybtfe\":\"35048.8\"},{\"jisuanhou\":\"0\",\"code\":\"12310101E78900019P\",\"bqybtfe\":\"90436.5\"},{\"jisuanhou\":\"0\",\"code\":\"913101203242203849\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"245600.4\",\"code\":\"91310113MA1GNY8C0B\",\"bqybtfe\":\"287296.7\"},{\"jisuanhou\":\"0\",\"code\":\"91310117734062024F\",\"bqybtfe\":\"74362.9\"},{\"jisuanhou\":\"0\",\"code\":\"91310120MA1J00E13H\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"913100006073869743\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"9131011468878229XD\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"62285.9\",\"code\":\"9144030035978442X2\",\"bqybtfe\":\"62285.9\"},{\"jisuanhou\":\"3489.3\",\"code\":\"12310000425202935T\",\"bqybtfe\":\"3489.3\"},{\"jisuanhou\":\"160247.4\",\"code\":\"91310104631318058J\",\"bqybtfe\":\"233256.7\"},{\"jisuanhou\":\"0\",\"code\":\"91310117685452551D\",\"bqybtfe\":\"28190.9\"},{\"jisuanhou\":\"0\",\"code\":\"9131011213330709XY\",\"bqybtfe\":\"111568.5\"},{\"jisuanhou\":\"0\",\"code\":\"91310114133652352F\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310115630863687U\",\"bqybtfe\":\"172596.4\"},{\"jisuanhou\":\"14908.5\",\"code\":\"313100003589244197\",\"bqybtfe\":\"14908.4\"},{\"jisuanhou\":\"\",\"code\":\"91310230MA1JXWXF6X\",\"bqybtfe\":\"41560.3\"},{\"jisuanhou\":\"0\",\"code\":\"91310120MA1HUF922X\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"18225.0\",\"code\":\"91310230MA1JU9LLXE\",\"bqybtfe\":\"18225\"},{\"jisuanhou\":\"16823.9\",\"code\":\"91310107MA1G0H2W48\",\"bqybtfe\":\"40519.9\"},{\"jisuanhou\":\"0\",\"code\":\"91310101674592225Q\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310114773711859A\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310112630573516G\",\"bqybtfe\":\"160731.1\"},{\"jisuanhou\":\"30075.0\",\"code\":\"91310105MA1FWF163K\",\"bqybtfe\":\"30075\"},{\"jisuanhou\":\"0\",\"code\":\"91310106630615034W\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"11310109002446153G\",\"bqybtfe\":\"3521379.1\"},{\"jisuanhou\":\"0\",\"code\":\"913101155964224498\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310101132430176E\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"138794.7\",\"code\":\"12310103425071285J\",\"bqybtfe\":\"374042.5\"},{\"jisuanhou\":\"62415.9\",\"code\":\"9131011455003626XB\",\"bqybtfe\":\"62415.9\"},{\"jisuanhou\":\"0\",\"code\":\"91310230631051066U\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"131485.1\",\"code\":\"9131000078360845XD\",\"bqybtfe\":\"140345.6\"},{\"jisuanhou\":\"0\",\"code\":\"913101061346740357\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"52310000310533515P\",\"bqybtfe\":\"9667.5\"},{\"jisuanhou\":\"7981.7\",\"code\":\"91310117MA1J24WJ71\",\"bqybtfe\":\"7981.7\"},{\"jisuanhou\":\"0\",\"code\":\"91310115MA1K3DNA75\",\"bqybtfe\":\"53453.8\"},{\"jisuanhou\":\"0\",\"code\":\"913101046302701019\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310107752912213F\",\"bqybtfe\":\"331319.4\"},{\"jisuanhou\":\"1928.9\",\"code\":\"31310000MD019026XY\",\"bqybtfe\":\"1928.9\"},{\"jisuanhou\":\"0\",\"code\":\"91310115MA1H796W7R\",\"bqybtfe\":\"40839.9\"},{\"jisuanhou\":\"0\",\"code\":\"91310113MA1GMC4289\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310000682255771Y\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"913101171341431629\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"1600772.8\",\"code\":\"91310000717850897G\",\"bqybtfe\":\"1717321.7\"},{\"jisuanhou\":\"0\",\"code\":\"91310112MA1GC2XG50\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310116563085685T\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"9131010958684615X5\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"913101156711545885\",\"bqybtfe\":\"74639.7\"},{\"jisuanhou\":\"19262.7\",\"code\":\"91310115132218079G\",\"bqybtfe\":\"57215.9\"},{\"jisuanhou\":\"0\",\"code\":\"91310116607349284E\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310113084105255U\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"913101207616214691\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310108682266630R\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"21679.0\",\"code\":\"91310104080007068W\",\"bqybtfe\":\"37856.2\"},{\"jisuanhou\":\"0\",\"code\":\"91310000607270330T\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"9131012077762746XH\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"124407.7\",\"code\":\"91310000332428521M\",\"bqybtfe\":\"124407.7\"},{\"jisuanhou\":\"0\",\"code\":\"91310230MA1HGHU84E\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310120065998051A\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"9428.4\",\"code\":\"913101070800223723\",\"bqybtfe\":\"72608.7\"},{\"jisuanhou\":\"0\",\"code\":\"913101176854794556\",\"bqybtfe\":\"62604.7\"},{\"jisuanhou\":\"7050.6\",\"code\":\"91310118MA1JNM2G59\",\"bqybtfe\":\"7050.6\"},{\"jisuanhou\":\"91222.9\",\"code\":\"9131010178951856X2\",\"bqybtfe\":\"200138\"},{\"jisuanhou\":\"227042.1\",\"code\":\"52310109336420324T\",\"bqybtfe\":\"306979.5\"},{\"jisuanhou\":\"0\",\"code\":\"913101176315276699\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310106631222435L\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310112666044675P\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"913101155981906026\",\"bqybtfe\":\"25804.9\"},{\"jisuanhou\":\"0\",\"code\":\"913101207970149192\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"798.2\",\"code\":\"513100003414712066\",\"bqybtfe\":\"798.2\"},{\"jisuanhou\":\"0\",\"code\":\"123101044250314358\",\"bqybtfe\":\"41623.1\"},{\"jisuanhou\":\"9752.6\",\"code\":\"1231011042508537XA\",\"bqybtfe\":\"177200.8\"},{\"jisuanhou\":\"0\",\"code\":\"91310108086242747E\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310110133227655J\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"106679.0\",\"code\":\"523101156887405754\",\"bqybtfe\":\"160419.6\"},{\"jisuanhou\":\"15494.4\",\"code\":\"313100006643833158\",\"bqybtfe\":\"15494.4\"},{\"jisuanhou\":\"0\",\"code\":\"523101013105005617\",\"bqybtfe\":\"1396.8\"},{\"jisuanhou\":\"0\",\"code\":\"91310118798932543E\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310000742696668H\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"3719.0\",\"code\":\"91310107MA1G0JE98C\",\"bqybtfe\":\"60236.4\"},{\"jisuanhou\":\"0\",\"code\":\"91310115MA1H846G84\",\"bqybtfe\":\"41248.8\"},{\"jisuanhou\":\"658886.0\",\"code\":\"11310000002472845G\",\"bqybtfe\":\"658886\"},{\"jisuanhou\":\"29321.1\",\"code\":\"91310117690192352F\",\"bqybtfe\":\"29321.1\"},{\"jisuanhou\":\"0\",\"code\":\"913101105852612139\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310106749596467P\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"9131010783291346XY\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310101MA1FPEHW7R\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310112MA1GDQ2754\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310112667822045F\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"378662.5\",\"code\":\"91310107057632500D\",\"bqybtfe\":\"439589.7\"},{\"jisuanhou\":\"0\",\"code\":\"11310106MB2F31402K\",\"bqybtfe\":\"19334.9\"},{\"jisuanhou\":\"11522.3\",\"code\":\"91310115MA1H9HTR5B\",\"bqybtfe\":\"20420\"},{\"jisuanhou\":\"0\",\"code\":\"91310116MA1JCNL160\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310000MA1FRE3K07\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"913101187737402708\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310230671177915C\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310230MA1JXRXF2U\",\"bqybtfe\":\"29165.9\"},{\"jisuanhou\":\"\",\"code\":\"91310112833307939D\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"12310116E788365981\",\"bqybtfe\":\"24330.3\"},{\"jisuanhou\":\"0\",\"code\":\"113101060024401576\",\"bqybtfe\":\"5469350.3\"},{\"jisuanhou\":\"0\",\"code\":\"913101123986462221\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310120MA1HMXY78K\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310117729522057N\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"212687.9\",\"code\":\"1231022542505504XU\",\"bqybtfe\":\"380842.4\"},{\"jisuanhou\":\"0\",\"code\":\"91310113703166699H\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310104132638540R\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"2261.5\",\"code\":\"3131000069157239XL\",\"bqybtfe\":\"2261.5\"},{\"jisuanhou\":\"0\",\"code\":\"91310105551534965C\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310110631131701W\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"30294.0\",\"code\":\"913101177390042374\",\"bqybtfe\":\"30294\"},{\"jisuanhou\":\"1619794.0\",\"code\":\"91310115761166689D\",\"bqybtfe\":\"1809421.4\"},{\"jisuanhou\":\"0\",\"code\":\"91310118324321265J\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310117631136772G\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"30748.5\",\"code\":\"913101127585717047\",\"bqybtfe\":\"30748.5\"},{\"jisuanhou\":\"0\",\"code\":\"91310105631458843F\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"913101156793943162\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310114MA1GXE3W2N\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"78687.0\",\"code\":\"9131011413363658XY\",\"bqybtfe\":\"94424.4\"},{\"jisuanhou\":\"45894.4\",\"code\":\"91310000694183592D\",\"bqybtfe\":\"62765.8\"},{\"jisuanhou\":\"17967.0\",\"code\":\"91310114MA1GW2CN8P\",\"bqybtfe\":\"27088.7\"},{\"jisuanhou\":\"0\",\"code\":\"91310117792708225W\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"67531.0\",\"code\":\"91310230769690741C\",\"bqybtfe\":\"67531\"},{\"jisuanhou\":\"0\",\"code\":\"91310110MA1G8BQA4F\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"913101200545729448\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"123402.9\",\"code\":\"91310115MA1HA9N42K\",\"bqybtfe\":\"123402.9\"},{\"jisuanhou\":\"0\",\"code\":\"91310117MA1J1CCC98\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"12310106425038004T\",\"bqybtfe\":\"154403.8\"},{\"jisuanhou\":\"0\",\"code\":\"91310112687323614R\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310110MA1G971K1P\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"134146.2\",\"code\":\"91310000MA1FP8JH0F\",\"bqybtfe\":\"134146.2\"},{\"jisuanhou\":\"129065.4\",\"code\":\"91310118MA1JLNKX0F\",\"bqybtfe\":\"129065.4\"},{\"jisuanhou\":\"0\",\"code\":\"9131011406604724XN\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"57135.9\",\"code\":\"91310118132185617F\",\"bqybtfe\":\"57135.9\"},{\"jisuanhou\":\"\",\"code\":\"513100005017685446\",\"bqybtfe\":\"21081.7\"},{\"jisuanhou\":\"\",\"code\":\"91310230MA1HG18PXU\",\"bqybtfe\":\"11107.9\"},{\"jisuanhou\":\"0\",\"code\":\"91310104570846489U\",\"bqybtfe\":\"35635.3\"},{\"jisuanhou\":\"122938.8\",\"code\":\"91310000749553571B\",\"bqybtfe\":\"227580.2\"},{\"jisuanhou\":\"0\",\"code\":\"91310117735417165A\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"12310115425052180H\",\"bqybtfe\":\"36024\"},{\"jisuanhou\":\"0\",\"code\":\"91310104770230080D\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"12310105425033131P\",\"bqybtfe\":\"127113.9\"},{\"jisuanhou\":\"0\",\"code\":\"9131011756808012XU\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"14832.8\",\"code\":\"91310118MA1JND8WX8\",\"bqybtfe\":\"14832.8\"},{\"jisuanhou\":\"0\",\"code\":\"123101064250416925\",\"bqybtfe\":\"133373.7\"},{\"jisuanhou\":\"49887.0\",\"code\":\"913101163423463781\",\"bqybtfe\":\"49887\"},{\"jisuanhou\":\"0\",\"code\":\"91310120MA1HUTD426\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"10614.7\",\"code\":\"31310000425002343F\",\"bqybtfe\":\"10614.7\"},{\"jisuanhou\":\"0\",\"code\":\"91310109MA1G51REXR\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310112630575909X\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310109760850999J\",\"bqybtfe\":\"63828.3\"},{\"jisuanhou\":\"0\",\"code\":\"913101205542960694\",\"bqybtfe\":\"28468.2\"},{\"jisuanhou\":\"25014.6\",\"code\":\"91310230MA1JYR8B6L\",\"bqybtfe\":\"25014.6\"},{\"jisuanhou\":\"0\",\"code\":\"52310115785153778F\",\"bqybtfe\":\"85072\"},{\"jisuanhou\":\"0\",\"code\":\"913101157737365461\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"9131011513394593X7\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310120MA1HUFD287\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310114MA1GWP0Q9G\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"603870.4\",\"code\":\"913100005834821784\",\"bqybtfe\":\"603870.4\"},{\"jisuanhou\":\"0\",\"code\":\"52310114757599692M\",\"bqybtfe\":\"8633.2\"},{\"jisuanhou\":\"0\",\"code\":\"91310116787858069R\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310230134407201A\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"55184.4\",\"code\":\"9131010733263267X3\",\"bqybtfe\":\"63159.3\"},{\"jisuanhou\":\"6984.0\",\"code\":\"91310116MA1JD1B93U\",\"bqybtfe\":\"6984\"},{\"jisuanhou\":\"0\",\"code\":\"9131012055591587XK\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"198977.0\",\"code\":\"91310115579120713U\",\"bqybtfe\":\"198977\"},{\"jisuanhou\":\"0\",\"code\":\"12310117E78835026E\",\"bqybtfe\":\"14112.6\"},{\"jisuanhou\":\"63650.7\",\"code\":\"913101173208714546\",\"bqybtfe\":\"63650.7\"},{\"jisuanhou\":\"0\",\"code\":\"913101180609141709\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"84316.7\",\"code\":\"91310109133152403Y\",\"bqybtfe\":\"84316.7\"},{\"jisuanhou\":\"0\",\"code\":\"9131011356309336X0\",\"bqybtfe\":\"24840.4\"},{\"jisuanhou\":\"0\",\"code\":\"91310115607690060K\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"75035.3\",\"code\":\"91310106579192063W\",\"bqybtfe\":\"75035.3\"},{\"jisuanhou\":\"0\",\"code\":\"913100006073165544\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310115631795663N\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"147594.0\",\"code\":\"913100007442173339\",\"bqybtfe\":\"147594\"},{\"jisuanhou\":\"0\",\"code\":\"913101051327102740\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310116MA1JDWWE2H\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"913101041326234292\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310112630774510A\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"36685.6\",\"code\":\"91310116742684675E\",\"bqybtfe\":\"36685.6\"},{\"jisuanhou\":\"0\",\"code\":\"91310115MA1H8FK81F\",\"bqybtfe\":\"94304.8\"},{\"jisuanhou\":\"0\",\"code\":\"91310118MA1JLXLL61\",\"bqybtfe\":\"28944.5\"},{\"jisuanhou\":\"592712.2\",\"code\":\"913100007492965529\",\"bqybtfe\":\"592712.2\"},{\"jisuanhou\":\"0\",\"code\":\"91310000754335421D\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"31006.4\",\"code\":\"91310113791469402T\",\"bqybtfe\":\"31006.4\"},{\"jisuanhou\":\"29440.3\",\"code\":\"91310000MA1H38KK3T\",\"bqybtfe\":\"29440.3\"},{\"jisuanhou\":\"0\",\"code\":\"91310117MA1J1UHD8Y\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310101133730365K\",\"bqybtfe\":\"62109.8\"},{\"jisuanhou\":\"0\",\"code\":\"91310120MA1HYH7N9J\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310230551572558R\",\"bqybtfe\":\"70785\"},{\"jisuanhou\":\"838.1\",\"code\":\"313100003124519516\",\"bqybtfe\":\"838.1\"},{\"jisuanhou\":\"\",\"code\":\"913101046694109094\",\"bqybtfe\":\"72168.3\"},{\"jisuanhou\":\"0\",\"code\":\"91310112324340853Y\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"18823.6\",\"code\":\"91310120MA1HK9DHXE\",\"bqybtfe\":\"18823.6\"},{\"jisuanhou\":\"26904.4\",\"code\":\"9131011863185626XN\",\"bqybtfe\":\"26904.4\"},{\"jisuanhou\":\"132037.1\",\"code\":\"913100007034761440\",\"bqybtfe\":\"275574.8\"},{\"jisuanhou\":\"0\",\"code\":\"9131011363170475X2\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310114735400064U\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"9131010113290102XP\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"16346.3\",\"code\":\"9131010832319556X6\",\"bqybtfe\":\"92024.8\"},{\"jisuanhou\":\"0\",\"code\":\"91310115133554744M\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"913101156762189588\",\"bqybtfe\":\"32417.4\"},{\"jisuanhou\":\"0\",\"code\":\"9131011763185482XP\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"913101103121931041\",\"bqybtfe\":\"53615.2\"},{\"jisuanhou\":\"0\",\"code\":\"91310230332788746H\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310110MA1G93QP0E\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"52310107MJ50751828\",\"bqybtfe\":\"24610.5\"},{\"jisuanhou\":\"82800.7\",\"code\":\"52310110MJ51119726\",\"bqybtfe\":\"100706.2\"},{\"jisuanhou\":\"\",\"code\":\"91310120750349922W\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310000MA1K34YX0J\",\"bqybtfe\":\"103460.2\"},{\"jisuanhou\":\"0\",\"code\":\"91310113574135086L\",\"bqybtfe\":\"42804.5\"},{\"jisuanhou\":\"0\",\"code\":\"913101143510424809\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"496860.2\",\"code\":\"91310117682230849G\",\"bqybtfe\":\"550883.4\"},{\"jisuanhou\":\"502649.4\",\"code\":\"91310115698763842Y\",\"bqybtfe\":\"502649.4\"},{\"jisuanhou\":\"0\",\"code\":\"91310000607328061M\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310107MA1G18JB1Y\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"104486.5\",\"code\":\"913101092426902517\",\"bqybtfe\":\"274386.8\"},{\"jisuanhou\":\"\",\"code\":\"91310114MA1GW1ME52\",\"bqybtfe\":\"514455.3\"},{\"jisuanhou\":\"13935382\",\"code\":\"913100006073717485\",\"bqybtfe\":\"14638006.2\"},{\"jisuanhou\":\"57332.7\",\"code\":\"91310000791411091R\",\"bqybtfe\":\"57332.7\"},{\"jisuanhou\":\"24186.4\",\"code\":\"913101066303502400\",\"bqybtfe\":\"148619.4\"},{\"jisuanhou\":\"19798.2\",\"code\":\"913101163419967233\",\"bqybtfe\":\"40001.6\"},{\"jisuanhou\":\"0\",\"code\":\"91310000671179806E\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"913101147461903656\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"9131010113301190XF\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"2079356.0\",\"code\":\"913100005867594438\",\"bqybtfe\":\"2079356\"},{\"jisuanhou\":\"0\",\"code\":\"913101137956212566\",\"bqybtfe\":\"57052.4\"},{\"jisuanhou\":\"75756.5\",\"code\":\"91310114MA1GW1983H\",\"bqybtfe\":\"75756.5\"},{\"jisuanhou\":\"0\",\"code\":\"91310110MA1G84UA0H\",\"bqybtfe\":\"198843.5\"},{\"jisuanhou\":\"83786.8\",\"code\":\"91310112MA1GCATG1C\",\"bqybtfe\":\"83786.8\"},{\"jisuanhou\":\"0\",\"code\":\"1131010400243622XK\",\"bqybtfe\":\"36477.9\"},{\"jisuanhou\":\"0\",\"code\":\"913101150659678020\",\"bqybtfe\":\"66354.3\"},{\"jisuanhou\":\"53505.2\",\"code\":\"12310110425086524A\",\"bqybtfe\":\"158019.1\"},{\"jisuanhou\":\"0\",\"code\":\"913100007426998936\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310105132724721J\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310109MA1G53F209\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310114133617944U\",\"bqybtfe\":\"40041.8\"},{\"jisuanhou\":\"39044.0\",\"code\":\"91310115132373415H\",\"bqybtfe\":\"39044\"},{\"jisuanhou\":\"7449.6\",\"code\":\"91310230MA1JW9NU7L\",\"bqybtfe\":\"7449.6\"},{\"jisuanhou\":\"0\",\"code\":\"91310115674599048L\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310106134694765H\",\"bqybtfe\":\"36863.4\"},{\"jisuanhou\":\"0\",\"code\":\"91310107132904247D\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"913101051327210026\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310115761154581Q\",\"bqybtfe\":\"92347\"},{\"jisuanhou\":\"0\",\"code\":\"91310000607340466H\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"913101177818764348\",\"bqybtfe\":\"55506.6\"},{\"jisuanhou\":\"0\",\"code\":\"91310000594703925C\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"913102303121744569\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310105554257895R\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310112067754472Y\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"121288.7\",\"code\":\"91310101MA1FPAM229\",\"bqybtfe\":\"121288.7\"},{\"jisuanhou\":\"0\",\"code\":\"91310117132133390D\",\"bqybtfe\":\"28601.2\"},{\"jisuanhou\":\"3458.7\",\"code\":\"91310118MA1JP2J41R\",\"bqybtfe\":\"3458.7\"},{\"jisuanhou\":\"0\",\"code\":\"91310112MA1GDTRT2F\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310118671193712R\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310115681003265A\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"9263.7\",\"code\":\"91310114684071343K\",\"bqybtfe\":\"94242.5\"},{\"jisuanhou\":\"0\",\"code\":\"9131011663098143XH\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"12310117669410175H\",\"bqybtfe\":\"16736.1\"},{\"jisuanhou\":\"0\",\"code\":\"91310113301761364F\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"190960.1\",\"code\":\"91310118751896055E\",\"bqybtfe\":\"242848.8\"},{\"jisuanhou\":\"30965.9\",\"code\":\"91310120062595273B\",\"bqybtfe\":\"49183.3\"},{\"jisuanhou\":\"0\",\"code\":\"91310116MA1JDWXL6R\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"9131012077374954XW\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"10110.2\",\"code\":\"52310113424866617E\",\"bqybtfe\":\"10110.2\"},{\"jisuanhou\":\"0\",\"code\":\"91310118785898964W\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310116MA1JAYT08H\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"913101157858893551\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310115092205862T\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310230134408327U\",\"bqybtfe\":\"457561.3\"},{\"jisuanhou\":\"6252.3\",\"code\":\"52310107310526577C\",\"bqybtfe\":\"6252.3\"},{\"jisuanhou\":\"0\",\"code\":\"51310000501777109B\",\"bqybtfe\":\"6318\"},{\"jisuanhou\":\"0\",\"code\":\"91310101MA1FPJXC9G\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"913101151339626682\",\"bqybtfe\":\"28667.7\"},{\"jisuanhou\":\"51406.8\",\"code\":\"913101125805960142\",\"bqybtfe\":\"51406.7\"},{\"jisuanhou\":\"0\",\"code\":\"913101156073968654\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310115133715974H\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310107797090639A\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"9131011406599072X6\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"100525.0\",\"code\":\"91310000552961838H\",\"bqybtfe\":\"100525\"},{\"jisuanhou\":\"0\",\"code\":\"913101205964265896\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"913101047728518684\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310117MA1J3EBD7B\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"30427.2\",\"code\":\"91310106557495944X\",\"bqybtfe\":\"30427.2\"},{\"jisuanhou\":\"0\",\"code\":\"91310112756101952L\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"6984.0\",\"code\":\"91310112MA1GCNA21R\",\"bqybtfe\":\"6984\"},{\"jisuanhou\":\"0\",\"code\":\"91310114MA1GWYN589\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310115MA1H8DQW0Y\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"9131011063038669X1\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"123101074251302304\",\"bqybtfe\":\"1780.3\"},{\"jisuanhou\":\"58311.9\",\"code\":\"913101133422645163\",\"bqybtfe\":\"58311.9\"},{\"jisuanhou\":\"0\",\"code\":\"91310118586794177R\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310116789505793A\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"913101153326656077\",\"bqybtfe\":\"26886.9\"},{\"jisuanhou\":\"110009.4\",\"code\":\"913101105601055726\",\"bqybtfe\":\"124407.5\"},{\"jisuanhou\":\"0\",\"code\":\"12310107358919388B\",\"bqybtfe\":\"44364.1\"},{\"jisuanhou\":\"0\",\"code\":\"91310105787801716U\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310230660749527B\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310112MA1GB69H6P\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310000607200658G\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"36792.0\",\"code\":\"91310120MA1HLTE74Y\",\"bqybtfe\":\"46105.2\"},{\"jisuanhou\":\"0\",\"code\":\"91310113MA1GPEQC1D\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"359151.2\",\"code\":\"123101154250157507\",\"bqybtfe\":\"537383.3\"},{\"jisuanhou\":\"270\",\"code\":\"53310000341481113R\",\"bqybtfe\":\"270\"},{\"jisuanhou\":\"0\",\"code\":\"91310106MA1FYFXU49\",\"bqybtfe\":\"50641.2\"},{\"jisuanhou\":\"51415.7\",\"code\":\"91310109132291823U\",\"bqybtfe\":\"51415.7\"},{\"jisuanhou\":\"0\",\"code\":\"91310113133410636R\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"913101158335269396\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"74323.7\",\"code\":\"91310112782429142L\",\"bqybtfe\":\"74323.7\"},{\"jisuanhou\":\"10446.7\",\"code\":\"91310230MA1JW8H6XF\",\"bqybtfe\":\"10446.7\"},{\"jisuanhou\":\"0\",\"code\":\"913101160747977454\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"9131011583283258XY\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310000757575017Y\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310118834256547B\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310116MA1JCU5M5G\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310117631891460L\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"91310230MA1JWCWE1C\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"913101146304580088\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"0\",\"code\":\"913101135601697526\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"21600.1\",\"code\":\"913101157461867965\",\"bqybtfe\":\"145400.7\"},{\"jisuanhou\":\"0\",\"code\":\"913101130660390710\",\"bqybtfe\":\"0\"},{\"jisuanhou\":\"79206.1\",\"code\":\"913101051327056945\",\"bqybtfe\":\"79206.1\"},{\"jisuanhou\":\"3947.9\",\"code\":\"91310000778094853R\",\"bqybtfe\":\"63943.5\"},{\"jisuanhou\":\"0\",\"code\":\"91310110398636059R\",\"bqybtfe\":\"0\"}]";
        JSONArray parse = JSONArray.parseArray(date);
        String date2 = "[\"91310114MA1GUD5Y2D\",\"91310112MA1GBJUN4K\",\"92310115MA1L7WEW4U\",\"91310230563074134L\",\"52310116MJ52644694\",\"91310110133206969A\",\"91310000X072033450\",\"913101207815201397\",\"91310104132672917N\",\"523101150820520149\",\"913100007862808165\",\"91310117076433195Y\",\"91310116598172332M\",\"52310230MJ53393284\",\"52310113742655874C\",\"52310105748777864E\",\"52310115082014237F\",\"11310118MB2F319208\",\"91310000737484345N\",\"913101156840036314\",\"91310000703240406B\",\"913102307895700189\",\"9131023008787819XX\",\"913101170764202553\",\"91310115579130946B\",\"91310116590377296A\",\"913101146304414413\",\"913100006693705566\",\"913101103123999469\",\"913101126987828240\",\"91310000MA1FYJMA1T\",\"52310117072974939X\",\"91310115093517876C\",\"11310226MB2F32165D\",\"12310117MB2F0683XQ\",\"91310117631163279B\",\"9131023059040168XM\",\"52310230MJ53394328\",\"523101137426559465\",\"91310000MA1FYG87X6\",\"91310105MA1FW4X32W\",\"913101185665814497\",\"91310000607418323K\",\"9131011574561893XG\",\"91310112133368431E\",\"52310117MJ5282034A\",\"93310118588651153A\",\"91310118555922324T\",\"52310115071230700J\",\"913101170764200871\",\"5231011508204636X2\",\"91310115MA1H9RBD3D\",\"52310107743277019C\",\"9131011460771101XM\",\"91310230580625137F\",\"91310000074776944A\",\"52310120MJ532322XP\",\"91310230133772258Q\",\"913101056311924673\",\"913101166762477679\",\"52310117072974947Q\",\"91310114133638374K\",\"91310107630724951A\",\"913101177032103547\",\"91310115053024735C\",\"52310105747291301K\",\"91310115631861077G\",\"91310000MA1FL01T07\",\"9131011363084649XY\",\"91310115MA1K3T4D4N\",\"5231023007120617XH\",\"91310000717852104L\",\"9131023009007490X7\",\"52310112080069875J\",\"91310113695778424Q\",\"913101166929907880\",\"91310114087867036H\",\"91310112698785929T\",\"91310112MA1GBXEY05\",\"52310117072975018W\",\"52310113742655938A\",\"913100000885149456\",\"913101170764201322\",\"91310107MA1G0F2B7H\",\"52310113742655970M\",\"91310113MA1GKR1R3Y\",\"91310112133300840T\",\"91310230MA1JUT359B\",\"913101143509781646\",\"91310120797033896K\",\"91310230MA1K217565\",\"91310115MA1K3Y9N10\",\"52310104084147746P\"]";
        JSONArray parse2 = JSONArray.parseArray(date2);

        // 创建工作簿 （使用了多态特性） HSSFWorkbook wb = new HSSFWorkbook();
        Workbook wb = new HSSFWorkbook();
        // 创建sheet页（使用的是带参构造器）
        Sheet sheet = wb.createSheet("应缴金额前后变化");
        Sheet sheet2 = wb.createSheet("未在441家企业名单内的企业");
        Row rows2 = sheet2.createRow(0);
        rows2.createCell(0).setCellValue("社会信用代码");
        Row rows = sheet.createRow(0);
        rows.createCell(0).setCellValue("社会信用代码");
        rows.createCell(1).setCellValue("60万底板应缴金额");
        rows.createCell(2).setCellValue("现应缴金额");
        for (int i = 0; i < parse.size(); i++) {
            JSONObject jsonObject = parse.getJSONObject(i);
            // 创建行（从0开始）
            Row row = sheet.createRow(i + 1);
            // //创建单元格(第一列)
            // Cell cell = row.createCell(0);
            // //给单元格赋值
            // cell.setCellValue("测试单元格内容");
            // 测试其他的赋值方式
            row.createCell(0).setCellValue(jsonObject.getString("code"));
            row.createCell(1).setCellValue(jsonObject.getString("bqybtfe"));
            row.createCell(2).setCellValue(jsonObject.getString("jisuanhou"));
        }

        for (int i = 0; i < parse2.size(); i++) {
            Row row = sheet2.createRow(i + 1);
            row.createCell(0).setCellValue(parse2.getString(i));
        }

        // 创建流并将wb输出
        FileOutputStream out = new FileOutputStream("src/main/resources/demo/excel/应缴金额.xls");
        wb.write(out);
        // 流的关闭
        out.close();
        System.out.printf("单元格创建其他值的示例成功");
    }

}


