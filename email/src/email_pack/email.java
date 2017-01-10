package email_pack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by vadim on 20.09.16.
 */
public class email
{
    public static void main(final String[] args)
    {
        String [] strings = {"kjdncskjs",
                            "csd",
                            "sdfsd@sdhf.ru",
                            "sdfsdsdhf.ru",
                            "sdfsd"};
        email em = new email();
        for(String s : strings) System.out.println(em.email_correct(s));
    }

    public boolean email_correct(String userNameString)
    {
        String regex = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(userNameString);
        return m.matches();
    }
}
