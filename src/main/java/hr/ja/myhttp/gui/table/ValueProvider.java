package hr.ja.myhttp.gui.table;

@FunctionalInterface
public interface ValueProvider<SOURCE, TARGET> {
    TARGET apply(SOURCE var1);
}