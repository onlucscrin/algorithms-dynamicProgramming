package org.algorithms.dynamicprogramming.longestCommonSubsequence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tup/palindromicSequence")
public class LCSTUPController {

    public Logger logger = LoggerFactory.getLogger(LCSTUPController.class);

    LCSTUPService lcsService;

    public LCSTUPController(LCSTUPService lcsService){
        this.lcsService = lcsService;
    }

    @GetMapping(path = "/longestPalindromicSequence/{inputString}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getLongestSubsequence(@PathVariable String inputString){
        try{
            return ResponseEntity.ok(this.lcsService.getLongestSubstring(inputString));
        } catch(Exception e){
            e.printStackTrace();
            logger.error(e.getLocalizedMessage());
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping(path = "/countPalindromicSubstring/{inputString}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> countPalindromicSubstring(@PathVariable String inputString){
        try{
            return ResponseEntity.ok(this.lcsService.countPalindromicSubstring(inputString));
        } catch(Exception e){
            e.printStackTrace();
            logger.error(e.getLocalizedMessage());
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping(path = "/minimumDeletionsStringPalindrome/{inputString}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> minimumDeletionsStringPalindrome(@PathVariable String inputString){
        try{
            return ResponseEntity.ok(this.lcsService.findMinimumDeletions(inputString));
        } catch(Exception e){
            e.printStackTrace();
            logger.error(e.getLocalizedMessage());
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping(path = "/minimumPartitionStringPalindrome/{inputString}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> minimumPartitionStringPalindrome(@PathVariable String inputString){
        try{
            return ResponseEntity.ok(this.lcsService.findMPPCuts(inputString));
        } catch(Exception e){
            e.printStackTrace();
            logger.error(e.getLocalizedMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
