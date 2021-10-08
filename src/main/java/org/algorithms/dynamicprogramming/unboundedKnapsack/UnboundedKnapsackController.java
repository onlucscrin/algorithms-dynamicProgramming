package org.algorithms.dynamicprogramming.unboundedKnapsack;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/unbounded/")
public class UnboundedKnapsackController {

    private UnboundedKnapsackService unboundedKnapsackService;

    public UnboundedKnapsackController(UnboundedKnapsackService unboundedKnapsackService){
        this.unboundedKnapsackService = unboundedKnapsackService;
    }

    @GetMapping(path = "/01knapsack/{capacity}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity solveKnapSack(@RequestBody int[][] profitWeights, @PathVariable int capacity){
        try{
            int result = this.unboundedKnapsackService.solveKnapsack(profitWeights[0], profitWeights[1], capacity);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping(path = "/rodCutting/{n}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> solveRodCutting(@RequestBody int[][] lengthPrices, @PathVariable int n){
        try{
            int result = this.unboundedKnapsackService.solveRodCutting(lengthPrices[0], lengthPrices[1], n);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping(path = "/coinChange/{amount}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> solveCoinChange(@RequestBody int[] denominations, @PathVariable int amount){
        try{
            int result = this.unboundedKnapsackService.countChange(denominations, amount);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping(path = "/minCoinChange/{amount}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> solveMinimumCoinChange(@RequestBody int[] denominations, @PathVariable int amount){
        try{
            int result = this.unboundedKnapsackService.countMinimumChange(denominations, amount);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping(path = "/maxRibbonCount/{n}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> solveMaxRibbonCount(@RequestBody int[] ribbons, @PathVariable int n){
        try{
            int result = this.unboundedKnapsackService.countRibbonPieces(ribbons, n);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
