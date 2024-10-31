package com.example.ui;

import com.example.database.Main.AddTransactionDAOMySQL;
import com.example.database.Main.GetListTransactionDAOMySQL;
import com.example.ui.add_transaction.AddTransactionController;
import com.example.ui.add_transaction.AddTransactionPresenter;
import com.example.ui.add_transaction.AddTransactionViewModel;
import com.example.ui.get_listTransaction.GetListTransactionController;
import com.example.ui.get_listTransaction.GetListTransactionPresenter;
import com.example.usecase.AddTransaction.AddTransactionUsecase;
import com.example.usecase.GetListTransaction.GetListTransactionUseCase;

public class TransactionAppMain {




  public static void main(String[] args) {
    TransactionFormView formMain = new TransactionFormView();

    GetListTransactionDAOMySQL getListTransactionDAOMySQL = new GetListTransactionDAOMySQL();
    GetListTransactionPresenter getListTransactionPresenter = new GetListTransactionPresenter(formMain);
    GetListTransactionUseCase getListTransactionUseCase = new GetListTransactionUseCase(getListTransactionPresenter,getListTransactionDAOMySQL);
    GetListTransactionController getListTransactionController = new GetListTransactionController(getListTransactionUseCase);

     
   // AddTransactionDetailForm addTransactionDetailForm = new AddTransactionDetailForm(null);
   AddTransactionViewModel addViewModel = new AddTransactionViewModel();
    AddTransactionDAOMySQL addTransactionDAOMySQL = new AddTransactionDAOMySQL();
    AddTransactionPresenter addTransactionPresenter = new AddTransactionPresenter(addViewModel);
    AddTransactionUsecase addTransactionUsecase = new AddTransactionUsecase(addTransactionPresenter,addTransactionDAOMySQL);
    AddTransactionController addTransactionController = new AddTransactionController(addTransactionUsecase);
   

    formMain.setGetListTransactionController(getListTransactionController);
    formMain.setAddTransactionController(addTransactionController);
    formMain.setAddViewModel(addViewModel);
    formMain.setVisible(true);
    getListTransactionController.execute();

  }
}
