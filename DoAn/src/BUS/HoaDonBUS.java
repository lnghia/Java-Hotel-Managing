/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAL.CTHoaDonDAL;
import DAL.CTSuDungDichVuDAL;
import DAL.CustomerDAL;
import DAL.DichVuDAL;
import DAL.HoaDonDAL;
import DAL.LoaiKhachHangDAL;
import DAL.LoaiPhongDAL;
import DAL.PhieuThuePhongDAL;
import DAL.PhongDAL;
import DAL.TiLePhuThuDAL;
import DTO.CTSuDungDichVuDTO;
import DTO.CustomerDTO;
import DTO.HoaDonDTO;
import DTO.PhieuThuePhongDTO;
/*import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;*/
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nghia
 */
public class HoaDonBUS {
    private static final String DEST="receipts/";
    private static final int LINE_NUM=7;
    
    private static HoaDonBUS instance;

    public static HoaDonBUS getInstance() {
        if(instance==null){
            instance=new HoaDonBUS();
        }
        
        return instance;
    }
    
    public String generateReceive(String id) throws ParseException{
        String path=DEST+id;
        PhieuThuePhongDTO phieuThue=PhieuThuePhongDAL.getInstance().getMostRecentPTPByRoomId(id);
        CustomerDTO customerDetail=CustomerDAL.getInstance().getCustomerInfo(phieuThue.getMaKH());
        float tiLe=TiLePhuThuDAL.getInstance().getTiLePhuThu(Integer.toString(phieuThue.getSoKhach()));
        float heSoPT=LoaiKhachHangDAL.getInstance().getHeSoPhuThu(customerDetail.getMaLoaiKH());
        String maLoaiPhong=PhongDAL.getInstance().getRoomTypeId(phieuThue.getMaPhong());
        float donGia=Float.parseFloat(LoaiPhongDAL.getInstance().getRoomTypeUnitPrice(maLoaiPhong));
        ArrayList<CTSuDungDichVuDTO> ctDvs=CTSuDungDichVuDAL.getInstance().getCTSuDungDVByPhong(phieuThue.getMaPhong(), phieuThue.getNgayBDThue().toString());
//        String maLoaiPhong=LoaiPhongDAL.getInstance().getRoomTypeUnitPrice()
//        ArrayList<CTSuDungDichVuDTO> ctDV=CTSuDungDichVuDAL.getInstance().getCTSuDungDVByPhong(maPhong);

        Date startDate=new SimpleDateFormat("MM/dd/yyyy").parse(phieuThue.getNgayBDThue());

        LocalDate tmp=LocalDate.now();
        LocalDate t=startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        int time=Period.between(LocalDate.now(), startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()).getDays();
        
        float tongTienThue=time*phieuThue.getDonGiaThue();
        tongTienThue+=(phieuThue.getSoKhach()>=3)?tongTienThue*25/100:0;
        
//        try {
//            BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream(path));
//            PdfWriter writer=new PdfWriter(out);
//            PdfDocument pdfDoc=new PdfDocument(writer);
//            Document doc=new Document(pdfDoc);
//            PdfPage page=pdfDoc.addNewPage();
//            PdfCanvas canvas=new PdfCanvas(page);
//            
//            doc.add(new Paragraph("Khách hàng: "+customerDetail.getHoTen()));
//            doc.add(new Paragraph("Ngày lập: "+LocalDate.now().toString()));
//            doc.add(new Paragraph("Số hóa đơn: "+generateInvoiceNum()));
//            
//            doc.add(new Paragraph(""));
//            doc.add(new Paragraph(""));
//            
//            canvas.moveTo(50, 100);
//            canvas.lineTo(550, 100);
//            
//            doc.add(new Paragraph(""));
//            doc.add(new Paragraph(""));
//            
//            Table table = new Table(new float[]{1, 3, 1, 1});
//            table.setWidth(UnitValue.createPercentValue(100));
//            table.addCell(createCell("Tên dịch vụ", 1, 2, TextAlignment.LEFT));
//            table.addCell(createCell("Số lượng", 1, 2, TextAlignment.RIGHT));
//            table.addCell(createCell("Đơn giá", 1, 2, TextAlignment.RIGHT));
//            table.addCell(createCell("Thành tiền", 1, 2, TextAlignment.RIGHT));
//            
//            HashSet<String> checked=new HashSet<>();
//            
//            float tongTienDV=0;
//            
//            for(CTSuDungDichVuDTO ct : ctDvs){
//                if(!checked.contains(ct.getMaDichVu())){
//                    int count=0;
//                
//                    count = ctDvs.stream().map((tmp) -> (tmp.getMaDichVu().equals(ct.getMaDichVu()))?1:0).reduce(count, Integer::sum);
//                
//                    table.addCell(createCell(DichVuDAL.getInstance().getTenDV(ct.getMaDichVu()), 1, 2, TextAlignment.LEFT));
//                    table.addCell(createCell(Integer.toString(count), 1, 2, TextAlignment.RIGHT));
//                    table.addCell(createCell(Float.toString(ct.getDonGia()), 1, 2, TextAlignment.RIGHT));
//                    table.addCell(createCell(Float.toString(ct.getDonGia()*count), 1, 2, TextAlignment.RIGHT));
//                
//                    checked.add(ct.getMaDichVu());
//                    
//                    tongTienDV+=count*ct.getDonGia();
//                }
//            }
//            
//            for(int i=0; i<LINE_NUM-checked.size(); ++i){
//                table.addCell(createCell("", 1, 2, TextAlignment.LEFT));
//                table.addCell(createCell("", 1, 2, TextAlignment.RIGHT));
//                table.addCell(createCell("", 1, 2, TextAlignment.RIGHT));
//                table.addCell(createCell("", 1, 2, TextAlignment.RIGHT));
//            }
//            
//            table.addCell(createCell("Thành tiền", 3, 2, TextAlignment.RIGHT));
//            table.addCell(createCell(Float.toString(tongTienThue+tongTienDV), 1, 2, TextAlignment.RIGHT));
//            
//            doc.close();
//            writer.close();
//            
//            return path;
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(HoaDonBUS.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(HoaDonBUS.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        return "";
    }
    
//    public void drawTable(float tongTienThue, )
    
    /*public Cell createCell(String content, int colSpan, float borderWidth, TextAlignment alignment){
        Cell cell = new Cell(1, colSpan).add(new Paragraph(content));
        
        cell.setTextAlignment(alignment);
        cell.setBorder(new SolidBorder(borderWidth));
        
        return cell;
    }*/
    
    public String generateInvoiceNum(){
        return Integer.toString(Integer.parseInt(HoaDonDAL.getInstance().getLatestInvoiceNum())+1);
    }
}
