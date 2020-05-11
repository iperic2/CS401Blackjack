//This program is a test plan -- consider it a document for tests which should be considered.

import org.junit.*; //import statement for using annotations

public class CardTest{
    @test public void CardIsNullWithDefaultConstructor(); //test constructors
    @test public void CardIsNotNullWithParameterizedConstructor();
    @test public void CardValueIsEqualToSetValues(); //test getters and setters 

}

public class DeckTest{
    @test public void DeckExistsAndIsNull();
    @test public void DeckExistsAndIsNotNull();
    @test public void GetCardIsNotNull();
    @test public void CreateTwoDecksAndShouldNotBeEqualToEachOther(); //ensure random element is in play
    @test public void DrawTwoCardsAndShouldNotBeEqualToEachOther();
    @test public void StopDrawShouldStopDraw(); //double check this test
    @test public void DisplayFrontSideShouldReturnSuitAndVal();
    @test public void DisplayBackSideShouldDisplayAmountOfCardsPlayerHas(); //double check
    @test public void ShuffleParameterObjectIsNotEqualToShuffleReturnObject();

}

public class MoneyTest{
    @test public void ChipValueEqualsDefaultValue();
    @test public void ChipValueIsNotNull();
    @test public void ChipValueIsEqualToSetInitialValueReturnAmt();
    @test public void ChipValueIsGreaterThanBeginningOfGame();
    @test public void ChipValueIsLessThanBeginningOfGame();
    @test public void SaveMoneyIsNotNull();
    @test public void SaveMoneyReturnsExpectedAmount();

}

public class PlayerTest{
    @test public void PlayerIsNotNull(); //constructor works
    @test public void PlayerSetInfoIsEqualToPlayerGetInfo(); //getters/setters work
    @test public void GetCurrentMoneyReturnsExpectedValue();
    @test public void OnCreatePlayerDoesNotReturnNull();
    @test public void SetHandReturnsNotNull();
    @test public void ToStringReturnsNotNull();
    
}

public class PlayerSizeTest{
    @test public void PlayerSizeIsNotNull();
    @test public void ObjectAfterAddNewPlayerIsNotNull();
    @test public void ObjectAfterAddNewPlayerIsNotEqualToPreviousObject(); 
    //ensures that the update was made to players playing the game
    @test public void AddOldPlayerDoesNotReturnNull();
    @test public void ObjectAfterAddOldPlayerIsNotEqualToPreviousObject();
    @test public void RemovePlayerDoesNotReturnNull();
    @test public void ObjectAfterRemovePlayerIsNotEqualToPreviousObject();
    
}