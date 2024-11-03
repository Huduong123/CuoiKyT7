package com.example.ui;

import com.example.database.Main.AddTransactionDAOMySQL;
import com.example.database.Main.CalAverageTransactionDAOMySQL;
import com.example.database.Main.CalTotalTransactionDAOMySQL;
import com.example.database.Main.DeleteTransactionDAOMySQL;
import com.example.database.Main.EditTransactionDAOMySQL;
import com.example.database.Main.GetListTransactionDAOMySQL;
import com.example.database.Main.SearchTransactionDAOMySQL;
import com.example.ui.add_transaction.AddTransactionController;
import com.example.ui.add_transaction.AddTransactionPresenter;
import com.example.ui.add_transaction.AddTransactionViewModel;
import com.example.ui.calAverage_transaction.CalAverageTranController;
import com.example.ui.calAverage_transaction.CalAverageTranPresenter;
import com.example.ui.calTotal_transaction.CalTotalTransactionController;
import com.example.ui.calTotal_transaction.CalTotalTransactionPresenter;
import com.example.ui.delete_transaction.DeleteTransactionController;
import com.example.ui.delete_transaction.DeleteTransactionPresenter;
import com.example.ui.delete_transaction.DeleteTransactionViewModel;
import com.example.ui.edit_transaction.EditTransactionController;
import com.example.ui.edit_transaction.EditTransactionPresenter;
import com.example.ui.edit_transaction.EditTransactionViewModel;
import com.example.ui.get_listTransaction.GetListTransactionController;
import com.example.ui.get_listTransaction.GetListTransactionPresenter;
import com.example.ui.search_transaction.SearchTransactionController;
import com.example.ui.search_transaction.SearchTransactionPresenter;
import com.example.usecase.AddTransaction.AddTransactionUsecase;
import com.example.usecase.CalAverageTransaction.CalAverageTransactionUseCase;
import com.example.usecase.CalTotalTransaction.CalTotalTransactionUseCase;
import com.example.usecase.DeleteTransaction.DeleteTransactionUseCase;
import com.example.usecase.EditTransaction.EditTransactionUseCase;
import com.example.usecase.GetListTransaction.GetListTransactionUseCase;
import com.example.usecase.SearchTransaction.SearchTransactionUseCase;

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
   
    EditTransactionViewModel editViewModel = new EditTransactionViewModel();
    EditTransactionDAOMySQL editTransactionDAOMySQL = new EditTransactionDAOMySQL();
    EditTransactionPresenter editTransactionPresenter = new EditTransactionPresenter(editViewModel);
    EditTransactionUseCase editTransactionUseCase = new EditTransactionUseCase(editTransactionPresenter, editTransactionDAOMySQL);
    EditTransactionController editTransactionController = new EditTransactionController(editTransactionUseCase);

    DeleteTransactionViewModel deleteViewModel = new DeleteTransactionViewModel();
    DeleteTransactionDAOMySQL deleteTransactionDAOMySQL = new DeleteTransactionDAOMySQL();
    DeleteTransactionPresenter deleteTransactionPresenter = new DeleteTransactionPresenter(deleteViewModel);
    DeleteTransactionUseCase deleteTransactionUseCase = new DeleteTransactionUseCase(deleteTransactionPresenter, deleteTransactionDAOMySQL);
    DeleteTransactionController deleteTransactionController = new DeleteTransactionController(deleteTransactionUseCase);



   
    SearchTransactionPresenter searchTransactionPresenter =   new SearchTransactionPresenter(formMain);
    SearchTransactionDAOMySQL searchTransactionDAOMySQL = new SearchTransactionDAOMySQL();
    SearchTransactionUseCase searchTransactionUseCase = new SearchTransactionUseCase(searchTransactionDAOMySQL, searchTransactionPresenter);
    SearchTransactionController searchTransactionController = new SearchTransactionController(searchTransactionUseCase);

    CalTotalTransactionPresenter calTotalTransactionPresenter = new CalTotalTransactionPresenter();
    CalTotalTransactionDAOMySQL calTotalTransactionDAOMySQL = new CalTotalTransactionDAOMySQL();
    CalTotalTransactionUseCase calTotalTransactionUseCase = new CalTotalTransactionUseCase(calTotalTransactionDAOMySQL, calTotalTransactionPresenter);
    CalTotalTransactionController calTotalTransactionController = new CalTotalTransactionController(calTotalTransactionUseCase);

    CalAverageTranPresenter calAverageTranPresenter = new CalAverageTranPresenter();
    CalAverageTransactionDAOMySQL calAverageTransactionDAOMySQL = new CalAverageTransactionDAOMySQL();
    CalAverageTransactionUseCase calAverageTransactionUseCase = new CalAverageTransactionUseCase(calAverageTranPresenter, calAverageTransactionDAOMySQL);
    CalAverageTranController calAverageTranController = new CalAverageTranController(calAverageTransactionUseCase);



    formMain.setGetListTransactionController(getListTransactionController);
    formMain.setAddTransactionController(addTransactionController);
    formMain.setEditTransactionController(editTransactionController);
    formMain.setDeleteTransactionController(deleteTransactionController);
    formMain.setSearchTransactionController(searchTransactionController);
    formMain.setCalTotalController(calTotalTransactionController);
    formMain.setCalAverageTranController(calAverageTranController);

    formMain.setAddViewModel(addViewModel);
    formMain.setEditViewModel(editViewModel);
    formMain.setDeleteViewModel(deleteViewModel);
    formMain.setCalTotalViewModel(null);

    formMain.setVisible(true);

    
  
    getListTransactionController.execute();

  }
}
