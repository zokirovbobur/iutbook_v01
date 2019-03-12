package bbro.iut_book_v01.staff.groupSection.groupsPerSection;

import bbro.iut_book_v01.group.Group_;
import bbro.iut_book_v01.staff.groupSection.GroupSection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class GroupsPerSection {
    @Id
    @GeneratedValue
    private long groupsPerSectionId;

    @ManyToOne
    private GroupSection groupSection;

    @ManyToOne
    private Group_ group;

    public long getGroupsPerSectionId() {
        return groupsPerSectionId;
    }

    public void setGroupsPerSectionId(long groupsPerSectionId) {
        this.groupsPerSectionId = groupsPerSectionId;
    }

    public GroupSection getGroupSection() {
        return groupSection;
    }

    public void setGroupSection(GroupSection groupSection) {
        this.groupSection = groupSection;
    }

    public Group_ getGroup() {
        return group;
    }

    public void setGroup(Group_ group) {
        this.group = group;
    }
}
