import dao.DAO;
import dao.DBConnection;
import vo.BaseVO;

/**
 * Created by dimitrov on 08.06.16.
 */
public class BaseLoader
{
    public static void main(String[] args)
    {
        if(args[0] == null)
            return;

        DAO dao = DAO.create(DBConnection.initDefault());
        String base = args[0];

        BaseVO vo = new BaseVO();
        vo.setBase(base);

        vo = dao.getVO(vo);

        System.out.print(vo.getDescription());
    }
}
