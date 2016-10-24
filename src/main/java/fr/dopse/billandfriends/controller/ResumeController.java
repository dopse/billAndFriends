package fr.dopse.billandfriends.controller;

import fr.dopse.billandfriends.exception.BillAndFriendsException;
import fr.dopse.billandfriends.model.Member;
import fr.dopse.billandfriends.model.Resume;
import fr.dopse.billandfriends.util.ResumeUtil;
import fr.dopse.billandfriends.util.VerificationUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller to get the resume.
 * Created by dopse.
 */

@RestController
@RequestMapping("/resume")
public class ResumeController {

    /**
     * get the Resume of actions.
     * @param memberList the list of members
     * @return the resume of bill
     */
    @RequestMapping(path = "/getResume", method = RequestMethod.POST)
    public Resume getResume(@RequestBody List<Member> memberList) throws BillAndFriendsException {

        for (Member member : memberList) {
            VerificationUtil.mandatoryValue(member.getName(), member.getPaid());
        }

        return ResumeUtil.getResumeByListMember(memberList);
    }
}
