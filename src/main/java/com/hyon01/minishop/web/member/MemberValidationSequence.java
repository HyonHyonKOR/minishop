package com.hyon01.minishop.web.member;

import javax.validation.GroupSequence;
import static com.hyon01.minishop.web.member.MemberValidationGroup.*;

@GroupSequence({NotBlankGroup.class, PatternGroup.class})
public interface MemberValidationSequence {
}
