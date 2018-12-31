import org.junit.Assert;

import org.junit.Test;



import sample.Battleground;

import sample.Controller;

import sample.Formation;

import sample.Formation;

import sample.Formation;

public class TestBattleground {
    @Test
    public void testBattleground()
    {
        Battleground battleground=new Battleground();
        battleground.init();
        Formation formation=new Formation();
        formation.singlelinearry(true);
        formation.fengshiarray(false);
        Assert.assertEquals(formation.numbers,7);
        Assert.assertEquals(battleground.ground[1][2],Battleground.calabashbrothers[0]);
        Assert.assertEquals(battleground.ground[2][2],Battleground.calabashbrothers[1]);
        Assert.assertEquals(battleground.ground[3][2],Battleground.calabashbrothers[2]);
        Assert.assertEquals(battleground.ground[4][2],Battleground.calabashbrothers[3]);
        Assert.assertEquals(battleground.ground[5][2],Battleground.calabashbrothers[4]);
        Assert.assertEquals(battleground.ground[6][2],Battleground.calabashbrothers[5]);
        Assert.assertEquals(battleground.ground[7][2],Battleground.calabashbrothers[6]);

    }
}
