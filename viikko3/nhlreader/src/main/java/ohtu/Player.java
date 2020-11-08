
package ohtu;

public class Player {
    private String name;
    private int goals;
    private int assists;
    private String team;
    private String birthdate;
    private int penalties;
    private String nationality;

    public void setName(String name) {
        this.name = name;
    }

    public int getGoals() {
        return goals;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public int getPenalties() {
        return penalties;
    }

    public void setPenalties(int penalties) {
        this.penalties = penalties;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getName() {
        return name;
    }
    
    public int getPoints() {
        return assists + goals;
    }

    @Override
    public String toString() {
        return name + " team " + team + " goals " + goals + " assists " + assists;
    }
      
}
