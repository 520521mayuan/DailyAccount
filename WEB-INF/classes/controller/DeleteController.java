package controller;

import dao.Deleteitemdao1;

/**
 * Created by 高芳健 on 2017/5/8.
 */
public class DeleteController implements IdeleteController {
    @Override
    //根据编号删除条目
    public Boolean deleteItem(String id) {
        Boolean flag=false;
        Deleteitemdao1 deleteitemdao1=new Deleteitemdao1();
        deleteitemdao1.deleteItem(id);
        return flag;
    }
}
