package controller;

import dao.Deleteitemdao1;

/**
 * Created by Administrator on 2017/5/8.
 */
public class DeleteController implements IdeleteController {
    @Override
    public Boolean deleteItem(String id) {
        Boolean flag=false;
        Deleteitemdao1 deleteitemdao1=new Deleteitemdao1();
        deleteitemdao1.deleteItem(id);
        return flag;
    }
}
