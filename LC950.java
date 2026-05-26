class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n=deck.length;
        Arrays.sort(deck);
        Deque<Integer> q=new ArrayDeque<>();
        q.addFirst(deck[n-1]);

        for(int i=n-2;i>=0;i--){
            q.addFirst(q.removeLast());
            q.addFirst(deck[i]);
        }

        for(int i=0;i<n;i++){
            deck[i]=q.removeFirst();
        }

        return deck;
    }
}
