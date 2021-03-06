package me.ugurcan.test;

import me.ugurcan.steamapi.CountryCode;
import me.ugurcan.steamapi.Game;
import me.ugurcan.steamapi.Games;
import me.ugurcan.steamapi.Language;
import me.ugurcan.steamapi.SearchMode;
import me.ugurcan.steamapi.SteamAPI;

public class Test {

    public static void main(String[] args) {

        SteamAPI steam = new SteamAPI(CountryCode.TR, Language.TURKISH);

        String gameTitle = "devil may cry";
        int numOfResults = 5; // upper limit for the number of games to be retrieved
        SearchMode searchMode = SearchMode.RELEVANCE; // see "SearchMode.java" for other search modes

        // search for games
        Games games = steam.searchForGames(gameTitle, numOfResults, searchMode);
        games.printAll();

        System.out.println();

        long startTime = System.currentTimeMillis();
        // retrieve game data
        Game game = games.get(0);
        steam.fillWithDetails(game);
        System.out.println(game);
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);

    }

}
