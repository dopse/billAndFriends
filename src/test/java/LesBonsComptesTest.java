import fr.dopse.billandfriends.model.Member;
import fr.dopse.billandfriends.model.Resume;
import fr.dopse.billandfriends.util.ResumeUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.*;
import static org.junit.Assert.*;

/**
 * Created by dopse on 22/10/2016.
 */
public class LesBonsComptesTest {

    private List<Member> creditMemberList = new ArrayList<>();

    @Before
    public void initialize() throws Exception {

        Member member = new Member();
        member.setName("Flavien");
        member.setPaid(18F);

        Member member1 = new Member();
        member1.setName("Estelle");
        member1.setPaid(12F);

        Member member2 = new Member();
        member2.setName("Felix");
        member2.setPaid(20F);

        Member member3 = new Member();
        member3.setName("Benoit");
        member3.setPaid(2F);

        Member member4 = new Member();
        member4.setName("Jacques");
        member4.setPaid(52F);

        creditMemberList.add(member);
        creditMemberList.add(member1);
        creditMemberList.add(member2);
        creditMemberList.add(member3);
        creditMemberList.add(member4);
    }

    @Test
    public void shouldReturnActionsWithValidResume() throws Exception {

        Resume resume = ResumeUtil.getResumeByListMember(creditMemberList);
        assertThat(resume.getActions(), hasSize(4));
        assertEquals(resume.getActions().get(0).getAmount(), "2,8");
        assertEquals(resume.getActions().get(1).getAmount(), "8,8");
        assertEquals(resume.getActions().get(2).getAmount(), "0,8");
        assertEquals(resume.getActions().get(3).getAmount(), "18,8");
    }

    @Test
    public void shouldNotReturnActions() throws Exception {

        Member member = new Member();
        member.setName("Flavien");
        member.setPaid(18F);

        Member member1 = new Member();
        member1.setName("Estelle");
        member1.setPaid(18F);

        Resume resume = ResumeUtil.getResumeByListMember(new ArrayList<>(Arrays.asList(member, member1)));
        assertThat(resume.getActions(), hasSize(0));
    }
}
