package com.example.ui;

import com.example.database.Main.AddTransactionDAOMySQL;
import com.example.database.Main.DeleteTransactionDAOMySQL;
import com.example.database.Main.EditTransactionDAOMySQL;
import com.example.database.Main.GetListTransactionDAOMySQL;
import com.example.ui.add_transaction.AddTransactionController;
import com.example.ui.add_transaction.AddTransactionPresenter;
import com.example.ui.add_transaction.AddTransactionViewModel;
import com.example.ui.delete_transaction.DeleteTransactionController;
import com.example.ui.delete_transaction.DeleteTransactionPresenter;
import com.example.ui.delete_transaction.DeleteTransactionViewModel;
import com.example.ui.edit_transaction.EditTransactionController;
import com.example.ui.edit_transaction.EditTransactionPresenter;
import com.example.ui.edit_transaction.EditTransactionViewModel;
import com.example.ui.get_listTransaction.GetListTransactionController;
import com.example.ui.get_listTransaction.GetListTransactionPresenter;
import com.example.usecase.AddTransaction.AddTransactionUsecase;
import com.example.usecase.DeleteTransaction.DeleteTransactionUseCase;
import com.example.usecase.EditTransaction.EditTransactionUseCase;
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

    formMain.setGetListTransactionController(getListTransactionController);
    formMain.setAddTransactionController(addTransactionController);
    formMain.setEditTransactionController(editTransactionController);
    formMain.setDeleteTransactionController(deleteTransactionController);

    formMain.setAddViewModel(addViewModel);
    formMain.setEditViewModel(editViewModel);
    formMain.setDeleteViewModel(deleteViewModel);
    formMain.setVisible(true);
    getListTransactionController.execute();

  }
}
