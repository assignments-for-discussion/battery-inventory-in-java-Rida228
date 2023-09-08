package bunchbysoh;

public class Main {
  static class CountsBySoH {
    public int healthy = 0;
    public int exchange = 0;
    public int failed = 0;
  };

  static CountsBySoH countBatteriesByHealth(int[] presentCapacities) {
    CountsBySoH counts = new CountsBySoH();
    int s=presentCapacities.length;
    for(int i=0;i<s;i++)
      {
        float soh = 100*(presentCapacities[i]/120);
        if(soh >= 80)
            counts.healthy += 1;
        else if((soh < 80) && (soh >= 65))
            counts.exchange += 1;
        else
            counts.failed += 1;
          }
    return counts;
  }

  static void testBucketingByHealth() {
    System.out.println("Counting batteries by SoH...\n");
    int[] presentCapacities = {115, 118, 80, 95, 91, 77};
    CountsBySoH counts = countBatteriesByHealth(presentCapacities);
    assert(counts.healthy == 2);
    assert(counts.exchange == 3);
    assert(counts.failed == 1);
    System.out.println("Done counting :)\n");
  }
  

  public static void main(String[] args) {
    testBucketingByHealth();
  }
}
