/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author tiitinha
 */
public class StatisticsTest {
    
    Reader readerStub = new Reader() {
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;
    
    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }
    
    @Test
    public void searchPalauttaaPelaajanJosOlemassa() {
        Player player = stats.search("Semenko");
        
        assertEquals(player.getName(), "Semenko");
    }
    
    @Test
    public void searchPalauttaaNullJosPelaajaaEiOle() {
        Player player = stats.search("Selänne");
        
        assertNull(player);
    }

    @Test
    public void teamPalauttaaOikeanPituisenListan() {
        List<Player> team = stats.team("EDM");
        
        assertEquals(3, team.size());
    }
    
    @Test
    public void topScoreresPalauttaaOikeanPituisenListan() {
        List<Player> topScorers = stats.topScorers(2);
        
        assertEquals(2, topScorers.size());
    }
    
    @Test
    public void topScorersOikeassaJärjestyksessä() {
        List<Player> topScorers = stats.topScorers(2);
        
        assertEquals("Gretzky", topScorers.get(0).getName());
    }
    
    
    

}
