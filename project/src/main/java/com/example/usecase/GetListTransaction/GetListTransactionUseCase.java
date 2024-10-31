package com.example.usecase.GetListTransaction;

import java.util.ArrayList;
import java.util.List;

import com.example.entity.House;
import com.example.entity.Land;
import com.example.entity.RealEstate;

public class GetListTransactionUseCase implements GetListTransactionInput {

    private GetListTransactionOutput getListTransactionOutput = null;
    private GetListTransactionDatabase getListTransactionDatabase = null;

    public GetListTransactionUseCase(GetListTransactionOutput getListTransactionOutput,
            GetListTransactionDatabase getListTransactionDatabase) {
        this.getListTransactionOutput = getListTransactionOutput;
        this.getListTransactionDatabase = getListTransactionDatabase;
    }

    @Override
    public void getListExecute() {
        List<GetListTransactionOutputDTO> listOutputDTO = new ArrayList<>();
        List<RealEstate> realEstateList = getListTransactionDatabase.getAllTransaction();

        for (RealEstate realEstate : realEstateList) {

            if (realEstate.getClass().equals(Land.class)) {
                Land land = (Land) realEstate;

                GetListTransactionOutputDTO landDTO = new GetListTransactionOutputDTO(
                        land.getMaGiaoDich(),
                        land.getNgayGiaoDich(),
                        land.getLoaiGiaoDich(),
                        land.getDonGia(),
                        land.getDienTich(),
                        land.getLoaiDat(),
                        land.thanhTien());

                listOutputDTO.add(landDTO);
                System.out.println("\nDanh sách giao dịch của bạn là:  \nMã giao dịch: " + land.getMaGiaoDich() 
                + "\nNgày giao dịch: " + land.getNgayGiaoDich()
                + "\nLoại giao dịch: " + land.getLoaiGiaoDich()
                + "\nĐơn giá: " + land.getDonGia()
                + "\nDiện tích: " + land.getDienTich()
                + "\nThành tiền: " + land.thanhTien());
            } else {
                House house = (House) realEstate;

                GetListTransactionOutputDTO houseDTO = new GetListTransactionOutputDTO(
                        house.getMaGiaoDich(),
                        house.getNgayGiaoDich(),
                        house.getLoaiGiaoDich(),
                        house.getDonGia(),
                        house.getDienTich(),
                        house.getLoaiNha(),
                        house.getDiaChi(),
                        house.thanhTien());

                listOutputDTO.add(houseDTO);
                System.out.println("\nDanh sách giao dịch của bạn là:  \nMã giao dịch: " + house.getMaGiaoDich() 
                + "\nNgày giao dịch: " + house.getNgayGiaoDich()
                + "\nLoại giao dịch: " + house.getLoaiGiaoDich()
                + "\nĐơn giá: " + house.getDonGia()
                + "\nDiện tích: " + house.getDienTich()
                + "\nLoại nhà: " + house.getLoaiNha()
                + "\nĐịa chỉ: " + house.getDiaChi()
                + "\nThành tiền: " + house.thanhTien());
            }

            getListTransactionOutput.presenter(listOutputDTO);
        }
    }

}
