package fr.dopse.billandfriends.util;

import fr.dopse.billandfriends.model.Action;
import fr.dopse.billandfriends.model.Member;
import fr.dopse.billandfriends.model.Resume;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * This class produce the resume of the bill.
 * Created by dopse.
 */
public class ResumeUtil {

    public static Resume getResumeByListMember(final List<Member> creditMemberList) {
        Resume resume = new Resume();

        final List<Member> loanMemberList = new ArrayList<>();

        Float total = 0F;

        for (final Member member : creditMemberList) {
            total += member.getPaid();
        }

        total = total / creditMemberList.size();

        createMemberListDebit(total, creditMemberList, loanMemberList);

        final List<Action> actionList = new ArrayList<>();

        for (final Member member : creditMemberList) {
            actionList.addAll(debitMember(member, loanMemberList));
        }

        resume.setActions(actionList);

        return resume;
    }

    private static void createMemberListDebit(final Float total, final List<Member> creditMemberList, final List<Member> loanMemberList) {
        CollectionUtils.filter(creditMemberList, new Predicate<Member>() {
            public boolean evaluate(Member member) {
                if(member.getPaid() < total) {
                    member.setBalance(total - member.getPaid());
                    loanMemberList.add(member);
                    return false;
                } else if(total.equals(member.getPaid())) {
                    return false;
                } else {
                    member.setBalance(member.getPaid() - total);
                    return true;
                }
            }
        });
    }

    private static List<Action> debitMember(final Member creditMember, final List<Member> loanMemberList) {

        final DecimalFormat df = new DecimalFormat("0.##");
        final List<Action> actionList = new ArrayList<>();

        CollectionUtils.find(loanMemberList, new Predicate<Member>() {
            public boolean evaluate(Member loanMember) {
                if(loanMember.getBalance().equals(0F)) {
                    return false;
                }
                Action action = new Action();

                if(loanMember.getBalance() < creditMember.getBalance()) {
                    action.setGiver(loanMember.getName());
                    action.setRecipient(creditMember.getName());
                    action.setAmount(df.format(loanMember.getBalance()));
                    creditMember.setBalance(creditMember.getBalance() - loanMember.getBalance());
                    loanMember.setBalance(0F);
                    actionList.add(action);
                    return false;
                } else if(loanMember.getBalance().equals(creditMember.getBalance())) {
                    action.setGiver(loanMember.getName());
                    action.setRecipient(creditMember.getName());
                    action.setAmount(df.format(loanMember.getBalance()));
                    loanMember.setBalance(0F);
                    actionList.add(action);
                    return true;
                } else {
                    action.setGiver(loanMember.getName());
                    action.setRecipient(creditMember.getName());
                    action.setAmount(df.format(creditMember.getBalance()));
                    loanMember.setBalance(loanMember.getBalance() - creditMember.getBalance());
                    actionList.add(action);
                    return true;
                }
            }
        });

        return actionList;
    }
}
