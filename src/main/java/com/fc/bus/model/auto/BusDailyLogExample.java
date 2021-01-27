package com.fc.bus.model.auto;

import cn.hutool.core.util.StrUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 施工日志表 BusDailyLogExample
 * @author cc_自动生成
 * @date 2021-01-26 16:43:19
 */
public class BusDailyLogExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BusDailyLogExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }
        
				
        public Criteria andIDIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIDIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIDEqualTo(String value) {
            addCriterion("ID =", value, "iD");
            return (Criteria) this;
        }

        public Criteria andIDNotEqualTo(String value) {
            addCriterion("ID <>", value, "iD");
            return (Criteria) this;
        }

        public Criteria andIDGreaterThan(String value) {
            addCriterion("ID >", value, "iD");
            return (Criteria) this;
        }

        public Criteria andIDGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "iD");
            return (Criteria) this;
        }

        public Criteria andIDLessThan(String value) {
            addCriterion("ID <", value, "iD");
            return (Criteria) this;
        }

        public Criteria andIDLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "iD");
            return (Criteria) this;
        }

        public Criteria andIDLike(String value) {
            addCriterion("ID like", value, "iD");
            return (Criteria) this;
        }

        public Criteria andIDNotLike(String value) {
            addCriterion("ID not like", value, "iD");
            return (Criteria) this;
        }

        public Criteria andIDIn(List<String> values) {
            addCriterion("ID in", values, "iD");
            return (Criteria) this;
        }

        public Criteria andIDNotIn(List<String> values) {
            addCriterion("ID not in", values, "iD");
            return (Criteria) this;
        }

        public Criteria andIDBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "iD");
            return (Criteria) this;
        }

        public Criteria andIDNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "iD");
            return (Criteria) this;
        }
        
				
        public Criteria andRBRQIsNull() {
            addCriterion("RBRQ is null");
            return (Criteria) this;
        }

        public Criteria andRBRQIsNotNull() {
            addCriterion("RBRQ is not null");
            return (Criteria) this;
        }

        public Criteria andRBRQEqualTo(String value) {
            addCriterion("RBRQ =", value, "rBRQ");
            return (Criteria) this;
        }

        public Criteria andRBRQNotEqualTo(String value) {
            addCriterion("RBRQ <>", value, "rBRQ");
            return (Criteria) this;
        }

        public Criteria andRBRQGreaterThan(String value) {
            addCriterion("RBRQ >", value, "rBRQ");
            return (Criteria) this;
        }

        public Criteria andRBRQGreaterThanOrEqualTo(String value) {
            addCriterion("RBRQ >=", value, "rBRQ");
            return (Criteria) this;
        }

        public Criteria andRBRQLessThan(String value) {
            addCriterion("RBRQ <", value, "rBRQ");
            return (Criteria) this;
        }

        public Criteria andRBRQLessThanOrEqualTo(String value) {
            addCriterion("RBRQ <=", value, "rBRQ");
            return (Criteria) this;
        }

        public Criteria andRBRQLike(String value) {
            addCriterion("RBRQ like", value, "rBRQ");
            return (Criteria) this;
        }

        public Criteria andRBRQNotLike(String value) {
            addCriterion("RBRQ not like", value, "rBRQ");
            return (Criteria) this;
        }

        public Criteria andRBRQIn(List<String> values) {
            addCriterion("RBRQ in", values, "rBRQ");
            return (Criteria) this;
        }

        public Criteria andRBRQNotIn(List<String> values) {
            addCriterion("RBRQ not in", values, "rBRQ");
            return (Criteria) this;
        }

        public Criteria andRBRQBetween(String value1, String value2) {
            addCriterion("RBRQ between", value1, value2, "rBRQ");
            return (Criteria) this;
        }

        public Criteria andRBRQNotBetween(String value1, String value2) {
            addCriterion("RBRQ not between", value1, value2, "rBRQ");
            return (Criteria) this;
        }
        
				
        public Criteria andXQJIsNull() {
            addCriterion("XQJ is null");
            return (Criteria) this;
        }

        public Criteria andXQJIsNotNull() {
            addCriterion("XQJ is not null");
            return (Criteria) this;
        }

        public Criteria andXQJEqualTo(String value) {
            addCriterion("XQJ =", value, "xQJ");
            return (Criteria) this;
        }

        public Criteria andXQJNotEqualTo(String value) {
            addCriterion("XQJ <>", value, "xQJ");
            return (Criteria) this;
        }

        public Criteria andXQJGreaterThan(String value) {
            addCriterion("XQJ >", value, "xQJ");
            return (Criteria) this;
        }

        public Criteria andXQJGreaterThanOrEqualTo(String value) {
            addCriterion("XQJ >=", value, "xQJ");
            return (Criteria) this;
        }

        public Criteria andXQJLessThan(String value) {
            addCriterion("XQJ <", value, "xQJ");
            return (Criteria) this;
        }

        public Criteria andXQJLessThanOrEqualTo(String value) {
            addCriterion("XQJ <=", value, "xQJ");
            return (Criteria) this;
        }

        public Criteria andXQJLike(String value) {
            addCriterion("XQJ like", value, "xQJ");
            return (Criteria) this;
        }

        public Criteria andXQJNotLike(String value) {
            addCriterion("XQJ not like", value, "xQJ");
            return (Criteria) this;
        }

        public Criteria andXQJIn(List<String> values) {
            addCriterion("XQJ in", values, "xQJ");
            return (Criteria) this;
        }

        public Criteria andXQJNotIn(List<String> values) {
            addCriterion("XQJ not in", values, "xQJ");
            return (Criteria) this;
        }

        public Criteria andXQJBetween(String value1, String value2) {
            addCriterion("XQJ between", value1, value2, "xQJ");
            return (Criteria) this;
        }

        public Criteria andXQJNotBetween(String value1, String value2) {
            addCriterion("XQJ not between", value1, value2, "xQJ");
            return (Criteria) this;
        }
        
				
        public Criteria andTQIsNull() {
            addCriterion("TQ is null");
            return (Criteria) this;
        }

        public Criteria andTQIsNotNull() {
            addCriterion("TQ is not null");
            return (Criteria) this;
        }

        public Criteria andTQEqualTo(String value) {
            addCriterion("TQ =", value, "tQ");
            return (Criteria) this;
        }

        public Criteria andTQNotEqualTo(String value) {
            addCriterion("TQ <>", value, "tQ");
            return (Criteria) this;
        }

        public Criteria andTQGreaterThan(String value) {
            addCriterion("TQ >", value, "tQ");
            return (Criteria) this;
        }

        public Criteria andTQGreaterThanOrEqualTo(String value) {
            addCriterion("TQ >=", value, "tQ");
            return (Criteria) this;
        }

        public Criteria andTQLessThan(String value) {
            addCriterion("TQ <", value, "tQ");
            return (Criteria) this;
        }

        public Criteria andTQLessThanOrEqualTo(String value) {
            addCriterion("TQ <=", value, "tQ");
            return (Criteria) this;
        }

        public Criteria andTQLike(String value) {
            addCriterion("TQ like", value, "tQ");
            return (Criteria) this;
        }

        public Criteria andTQNotLike(String value) {
            addCriterion("TQ not like", value, "tQ");
            return (Criteria) this;
        }

        public Criteria andTQIn(List<String> values) {
            addCriterion("TQ in", values, "tQ");
            return (Criteria) this;
        }

        public Criteria andTQNotIn(List<String> values) {
            addCriterion("TQ not in", values, "tQ");
            return (Criteria) this;
        }

        public Criteria andTQBetween(String value1, String value2) {
            addCriterion("TQ between", value1, value2, "tQ");
            return (Criteria) this;
        }

        public Criteria andTQNotBetween(String value1, String value2) {
            addCriterion("TQ not between", value1, value2, "tQ");
            return (Criteria) this;
        }
        
				
        public Criteria andSGBWIsNull() {
            addCriterion("SGBW is null");
            return (Criteria) this;
        }

        public Criteria andSGBWIsNotNull() {
            addCriterion("SGBW is not null");
            return (Criteria) this;
        }

        public Criteria andSGBWEqualTo(String value) {
            addCriterion("SGBW =", value, "sGBW");
            return (Criteria) this;
        }

        public Criteria andSGBWNotEqualTo(String value) {
            addCriterion("SGBW <>", value, "sGBW");
            return (Criteria) this;
        }

        public Criteria andSGBWGreaterThan(String value) {
            addCriterion("SGBW >", value, "sGBW");
            return (Criteria) this;
        }

        public Criteria andSGBWGreaterThanOrEqualTo(String value) {
            addCriterion("SGBW >=", value, "sGBW");
            return (Criteria) this;
        }

        public Criteria andSGBWLessThan(String value) {
            addCriterion("SGBW <", value, "sGBW");
            return (Criteria) this;
        }

        public Criteria andSGBWLessThanOrEqualTo(String value) {
            addCriterion("SGBW <=", value, "sGBW");
            return (Criteria) this;
        }

        public Criteria andSGBWLike(String value) {
            addCriterion("SGBW like", value, "sGBW");
            return (Criteria) this;
        }

        public Criteria andSGBWNotLike(String value) {
            addCriterion("SGBW not like", value, "sGBW");
            return (Criteria) this;
        }

        public Criteria andSGBWIn(List<String> values) {
            addCriterion("SGBW in", values, "sGBW");
            return (Criteria) this;
        }

        public Criteria andSGBWNotIn(List<String> values) {
            addCriterion("SGBW not in", values, "sGBW");
            return (Criteria) this;
        }

        public Criteria andSGBWBetween(String value1, String value2) {
            addCriterion("SGBW between", value1, value2, "sGBW");
            return (Criteria) this;
        }

        public Criteria andSGBWNotBetween(String value1, String value2) {
            addCriterion("SGBW not between", value1, value2, "sGBW");
            return (Criteria) this;
        }
        
				
        public Criteria andSGNRIsNull() {
            addCriterion("SGNR is null");
            return (Criteria) this;
        }

        public Criteria andSGNRIsNotNull() {
            addCriterion("SGNR is not null");
            return (Criteria) this;
        }

        public Criteria andSGNREqualTo(String value) {
            addCriterion("SGNR =", value, "sGNR");
            return (Criteria) this;
        }

        public Criteria andSGNRNotEqualTo(String value) {
            addCriterion("SGNR <>", value, "sGNR");
            return (Criteria) this;
        }

        public Criteria andSGNRGreaterThan(String value) {
            addCriterion("SGNR >", value, "sGNR");
            return (Criteria) this;
        }

        public Criteria andSGNRGreaterThanOrEqualTo(String value) {
            addCriterion("SGNR >=", value, "sGNR");
            return (Criteria) this;
        }

        public Criteria andSGNRLessThan(String value) {
            addCriterion("SGNR <", value, "sGNR");
            return (Criteria) this;
        }

        public Criteria andSGNRLessThanOrEqualTo(String value) {
            addCriterion("SGNR <=", value, "sGNR");
            return (Criteria) this;
        }

        public Criteria andSGNRLike(String value) {
            addCriterion("SGNR like", value, "sGNR");
            return (Criteria) this;
        }

        public Criteria andSGNRNotLike(String value) {
            addCriterion("SGNR not like", value, "sGNR");
            return (Criteria) this;
        }

        public Criteria andSGNRIn(List<String> values) {
            addCriterion("SGNR in", values, "sGNR");
            return (Criteria) this;
        }

        public Criteria andSGNRNotIn(List<String> values) {
            addCriterion("SGNR not in", values, "sGNR");
            return (Criteria) this;
        }

        public Criteria andSGNRBetween(String value1, String value2) {
            addCriterion("SGNR between", value1, value2, "sGNR");
            return (Criteria) this;
        }

        public Criteria andSGNRNotBetween(String value1, String value2) {
            addCriterion("SGNR not between", value1, value2, "sGNR");
            return (Criteria) this;
        }
        
				
        public Criteria andXXJDIsNull() {
            addCriterion("XXJD is null");
            return (Criteria) this;
        }

        public Criteria andXXJDIsNotNull() {
            addCriterion("XXJD is not null");
            return (Criteria) this;
        }

        public Criteria andXXJDEqualTo(String value) {
            addCriterion("XXJD =", value, "xXJD");
            return (Criteria) this;
        }

        public Criteria andXXJDNotEqualTo(String value) {
            addCriterion("XXJD <>", value, "xXJD");
            return (Criteria) this;
        }

        public Criteria andXXJDGreaterThan(String value) {
            addCriterion("XXJD >", value, "xXJD");
            return (Criteria) this;
        }

        public Criteria andXXJDGreaterThanOrEqualTo(String value) {
            addCriterion("XXJD >=", value, "xXJD");
            return (Criteria) this;
        }

        public Criteria andXXJDLessThan(String value) {
            addCriterion("XXJD <", value, "xXJD");
            return (Criteria) this;
        }

        public Criteria andXXJDLessThanOrEqualTo(String value) {
            addCriterion("XXJD <=", value, "xXJD");
            return (Criteria) this;
        }

        public Criteria andXXJDLike(String value) {
            addCriterion("XXJD like", value, "xXJD");
            return (Criteria) this;
        }

        public Criteria andXXJDNotLike(String value) {
            addCriterion("XXJD not like", value, "xXJD");
            return (Criteria) this;
        }

        public Criteria andXXJDIn(List<String> values) {
            addCriterion("XXJD in", values, "xXJD");
            return (Criteria) this;
        }

        public Criteria andXXJDNotIn(List<String> values) {
            addCriterion("XXJD not in", values, "xXJD");
            return (Criteria) this;
        }

        public Criteria andXXJDBetween(String value1, String value2) {
            addCriterion("XXJD between", value1, value2, "xXJD");
            return (Criteria) this;
        }

        public Criteria andXXJDNotBetween(String value1, String value2) {
            addCriterion("XXJD not between", value1, value2, "xXJD");
            return (Criteria) this;
        }
        
				
        public Criteria andSGRYIsNull() {
            addCriterion("SGRY is null");
            return (Criteria) this;
        }

        public Criteria andSGRYIsNotNull() {
            addCriterion("SGRY is not null");
            return (Criteria) this;
        }

        public Criteria andSGRYEqualTo(String value) {
            addCriterion("SGRY =", value, "sGRY");
            return (Criteria) this;
        }

        public Criteria andSGRYNotEqualTo(String value) {
            addCriterion("SGRY <>", value, "sGRY");
            return (Criteria) this;
        }

        public Criteria andSGRYGreaterThan(String value) {
            addCriterion("SGRY >", value, "sGRY");
            return (Criteria) this;
        }

        public Criteria andSGRYGreaterThanOrEqualTo(String value) {
            addCriterion("SGRY >=", value, "sGRY");
            return (Criteria) this;
        }

        public Criteria andSGRYLessThan(String value) {
            addCriterion("SGRY <", value, "sGRY");
            return (Criteria) this;
        }

        public Criteria andSGRYLessThanOrEqualTo(String value) {
            addCriterion("SGRY <=", value, "sGRY");
            return (Criteria) this;
        }

        public Criteria andSGRYLike(String value) {
            addCriterion("SGRY like", value, "sGRY");
            return (Criteria) this;
        }

        public Criteria andSGRYNotLike(String value) {
            addCriterion("SGRY not like", value, "sGRY");
            return (Criteria) this;
        }

        public Criteria andSGRYIn(List<String> values) {
            addCriterion("SGRY in", values, "sGRY");
            return (Criteria) this;
        }

        public Criteria andSGRYNotIn(List<String> values) {
            addCriterion("SGRY not in", values, "sGRY");
            return (Criteria) this;
        }

        public Criteria andSGRYBetween(String value1, String value2) {
            addCriterion("SGRY between", value1, value2, "sGRY");
            return (Criteria) this;
        }

        public Criteria andSGRYNotBetween(String value1, String value2) {
            addCriterion("SGRY not between", value1, value2, "sGRY");
            return (Criteria) this;
        }
        
				
        public Criteria andSGJDIsNull() {
            addCriterion("SGJD is null");
            return (Criteria) this;
        }

        public Criteria andSGJDIsNotNull() {
            addCriterion("SGJD is not null");
            return (Criteria) this;
        }

        public Criteria andSGJDEqualTo(String value) {
            addCriterion("SGJD =", value, "sGJD");
            return (Criteria) this;
        }

        public Criteria andSGJDNotEqualTo(String value) {
            addCriterion("SGJD <>", value, "sGJD");
            return (Criteria) this;
        }

        public Criteria andSGJDGreaterThan(String value) {
            addCriterion("SGJD >", value, "sGJD");
            return (Criteria) this;
        }

        public Criteria andSGJDGreaterThanOrEqualTo(String value) {
            addCriterion("SGJD >=", value, "sGJD");
            return (Criteria) this;
        }

        public Criteria andSGJDLessThan(String value) {
            addCriterion("SGJD <", value, "sGJD");
            return (Criteria) this;
        }

        public Criteria andSGJDLessThanOrEqualTo(String value) {
            addCriterion("SGJD <=", value, "sGJD");
            return (Criteria) this;
        }

        public Criteria andSGJDLike(String value) {
            addCriterion("SGJD like", value, "sGJD");
            return (Criteria) this;
        }

        public Criteria andSGJDNotLike(String value) {
            addCriterion("SGJD not like", value, "sGJD");
            return (Criteria) this;
        }

        public Criteria andSGJDIn(List<String> values) {
            addCriterion("SGJD in", values, "sGJD");
            return (Criteria) this;
        }

        public Criteria andSGJDNotIn(List<String> values) {
            addCriterion("SGJD not in", values, "sGJD");
            return (Criteria) this;
        }

        public Criteria andSGJDBetween(String value1, String value2) {
            addCriterion("SGJD between", value1, value2, "sGJD");
            return (Criteria) this;
        }

        public Criteria andSGJDNotBetween(String value1, String value2) {
            addCriterion("SGJD not between", value1, value2, "sGJD");
            return (Criteria) this;
        }
        
				
        public Criteria andJSZLJLIsNull() {
            addCriterion("JSZLJL is null");
            return (Criteria) this;
        }

        public Criteria andJSZLJLIsNotNull() {
            addCriterion("JSZLJL is not null");
            return (Criteria) this;
        }

        public Criteria andJSZLJLEqualTo(String value) {
            addCriterion("JSZLJL =", value, "jSZLJL");
            return (Criteria) this;
        }

        public Criteria andJSZLJLNotEqualTo(String value) {
            addCriterion("JSZLJL <>", value, "jSZLJL");
            return (Criteria) this;
        }

        public Criteria andJSZLJLGreaterThan(String value) {
            addCriterion("JSZLJL >", value, "jSZLJL");
            return (Criteria) this;
        }

        public Criteria andJSZLJLGreaterThanOrEqualTo(String value) {
            addCriterion("JSZLJL >=", value, "jSZLJL");
            return (Criteria) this;
        }

        public Criteria andJSZLJLLessThan(String value) {
            addCriterion("JSZLJL <", value, "jSZLJL");
            return (Criteria) this;
        }

        public Criteria andJSZLJLLessThanOrEqualTo(String value) {
            addCriterion("JSZLJL <=", value, "jSZLJL");
            return (Criteria) this;
        }

        public Criteria andJSZLJLLike(String value) {
            addCriterion("JSZLJL like", value, "jSZLJL");
            return (Criteria) this;
        }

        public Criteria andJSZLJLNotLike(String value) {
            addCriterion("JSZLJL not like", value, "jSZLJL");
            return (Criteria) this;
        }

        public Criteria andJSZLJLIn(List<String> values) {
            addCriterion("JSZLJL in", values, "jSZLJL");
            return (Criteria) this;
        }

        public Criteria andJSZLJLNotIn(List<String> values) {
            addCriterion("JSZLJL not in", values, "jSZLJL");
            return (Criteria) this;
        }

        public Criteria andJSZLJLBetween(String value1, String value2) {
            addCriterion("JSZLJL between", value1, value2, "jSZLJL");
            return (Criteria) this;
        }

        public Criteria andJSZLJLNotBetween(String value1, String value2) {
            addCriterion("JSZLJL not between", value1, value2, "jSZLJL");
            return (Criteria) this;
        }
        
				
        public Criteria andJCCLJLIsNull() {
            addCriterion("JCCLJL is null");
            return (Criteria) this;
        }

        public Criteria andJCCLJLIsNotNull() {
            addCriterion("JCCLJL is not null");
            return (Criteria) this;
        }

        public Criteria andJCCLJLEqualTo(String value) {
            addCriterion("JCCLJL =", value, "jCCLJL");
            return (Criteria) this;
        }

        public Criteria andJCCLJLNotEqualTo(String value) {
            addCriterion("JCCLJL <>", value, "jCCLJL");
            return (Criteria) this;
        }

        public Criteria andJCCLJLGreaterThan(String value) {
            addCriterion("JCCLJL >", value, "jCCLJL");
            return (Criteria) this;
        }

        public Criteria andJCCLJLGreaterThanOrEqualTo(String value) {
            addCriterion("JCCLJL >=", value, "jCCLJL");
            return (Criteria) this;
        }

        public Criteria andJCCLJLLessThan(String value) {
            addCriterion("JCCLJL <", value, "jCCLJL");
            return (Criteria) this;
        }

        public Criteria andJCCLJLLessThanOrEqualTo(String value) {
            addCriterion("JCCLJL <=", value, "jCCLJL");
            return (Criteria) this;
        }

        public Criteria andJCCLJLLike(String value) {
            addCriterion("JCCLJL like", value, "jCCLJL");
            return (Criteria) this;
        }

        public Criteria andJCCLJLNotLike(String value) {
            addCriterion("JCCLJL not like", value, "jCCLJL");
            return (Criteria) this;
        }

        public Criteria andJCCLJLIn(List<String> values) {
            addCriterion("JCCLJL in", values, "jCCLJL");
            return (Criteria) this;
        }

        public Criteria andJCCLJLNotIn(List<String> values) {
            addCriterion("JCCLJL not in", values, "jCCLJL");
            return (Criteria) this;
        }

        public Criteria andJCCLJLBetween(String value1, String value2) {
            addCriterion("JCCLJL between", value1, value2, "jCCLJL");
            return (Criteria) this;
        }

        public Criteria andJCCLJLNotBetween(String value1, String value2) {
            addCriterion("JCCLJL not between", value1, value2, "jCCLJL");
            return (Criteria) this;
        }
        
				
        public Criteria andGCFZRIsNull() {
            addCriterion("GCFZR is null");
            return (Criteria) this;
        }

        public Criteria andGCFZRIsNotNull() {
            addCriterion("GCFZR is not null");
            return (Criteria) this;
        }

        public Criteria andGCFZREqualTo(String value) {
            addCriterion("GCFZR =", value, "gCFZR");
            return (Criteria) this;
        }

        public Criteria andGCFZRNotEqualTo(String value) {
            addCriterion("GCFZR <>", value, "gCFZR");
            return (Criteria) this;
        }

        public Criteria andGCFZRGreaterThan(String value) {
            addCriterion("GCFZR >", value, "gCFZR");
            return (Criteria) this;
        }

        public Criteria andGCFZRGreaterThanOrEqualTo(String value) {
            addCriterion("GCFZR >=", value, "gCFZR");
            return (Criteria) this;
        }

        public Criteria andGCFZRLessThan(String value) {
            addCriterion("GCFZR <", value, "gCFZR");
            return (Criteria) this;
        }

        public Criteria andGCFZRLessThanOrEqualTo(String value) {
            addCriterion("GCFZR <=", value, "gCFZR");
            return (Criteria) this;
        }

        public Criteria andGCFZRLike(String value) {
            addCriterion("GCFZR like", value, "gCFZR");
            return (Criteria) this;
        }

        public Criteria andGCFZRNotLike(String value) {
            addCriterion("GCFZR not like", value, "gCFZR");
            return (Criteria) this;
        }

        public Criteria andGCFZRIn(List<String> values) {
            addCriterion("GCFZR in", values, "gCFZR");
            return (Criteria) this;
        }

        public Criteria andGCFZRNotIn(List<String> values) {
            addCriterion("GCFZR not in", values, "gCFZR");
            return (Criteria) this;
        }

        public Criteria andGCFZRBetween(String value1, String value2) {
            addCriterion("GCFZR between", value1, value2, "gCFZR");
            return (Criteria) this;
        }

        public Criteria andGCFZRNotBetween(String value1, String value2) {
            addCriterion("GCFZR not between", value1, value2, "gCFZR");
            return (Criteria) this;
        }
        
				
        public Criteria andJLRIsNull() {
            addCriterion("JLR is null");
            return (Criteria) this;
        }

        public Criteria andJLRIsNotNull() {
            addCriterion("JLR is not null");
            return (Criteria) this;
        }

        public Criteria andJLREqualTo(String value) {
            addCriterion("JLR =", value, "jLR");
            return (Criteria) this;
        }

        public Criteria andJLRNotEqualTo(String value) {
            addCriterion("JLR <>", value, "jLR");
            return (Criteria) this;
        }

        public Criteria andJLRGreaterThan(String value) {
            addCriterion("JLR >", value, "jLR");
            return (Criteria) this;
        }

        public Criteria andJLRGreaterThanOrEqualTo(String value) {
            addCriterion("JLR >=", value, "jLR");
            return (Criteria) this;
        }

        public Criteria andJLRLessThan(String value) {
            addCriterion("JLR <", value, "jLR");
            return (Criteria) this;
        }

        public Criteria andJLRLessThanOrEqualTo(String value) {
            addCriterion("JLR <=", value, "jLR");
            return (Criteria) this;
        }

        public Criteria andJLRLike(String value) {
            addCriterion("JLR like", value, "jLR");
            return (Criteria) this;
        }

        public Criteria andJLRNotLike(String value) {
            addCriterion("JLR not like", value, "jLR");
            return (Criteria) this;
        }

        public Criteria andJLRIn(List<String> values) {
            addCriterion("JLR in", values, "jLR");
            return (Criteria) this;
        }

        public Criteria andJLRNotIn(List<String> values) {
            addCriterion("JLR not in", values, "jLR");
            return (Criteria) this;
        }

        public Criteria andJLRBetween(String value1, String value2) {
            addCriterion("JLR between", value1, value2, "jLR");
            return (Criteria) this;
        }

        public Criteria andJLRNotBetween(String value1, String value2) {
            addCriterion("JLR not between", value1, value2, "jLR");
            return (Criteria) this;
        }
        
				
        public Criteria andTJSJIsNull() {
            addCriterion("TJSJ is null");
            return (Criteria) this;
        }

        public Criteria andTJSJIsNotNull() {
            addCriterion("TJSJ is not null");
            return (Criteria) this;
        }

        public Criteria andTJSJEqualTo(String value) {
            addCriterion("TJSJ =", value, "tJSJ");
            return (Criteria) this;
        }

        public Criteria andTJSJNotEqualTo(String value) {
            addCriterion("TJSJ <>", value, "tJSJ");
            return (Criteria) this;
        }

        public Criteria andTJSJGreaterThan(String value) {
            addCriterion("TJSJ >", value, "tJSJ");
            return (Criteria) this;
        }

        public Criteria andTJSJGreaterThanOrEqualTo(String value) {
            addCriterion("TJSJ >=", value, "tJSJ");
            return (Criteria) this;
        }

        public Criteria andTJSJLessThan(String value) {
            addCriterion("TJSJ <", value, "tJSJ");
            return (Criteria) this;
        }

        public Criteria andTJSJLessThanOrEqualTo(String value) {
            addCriterion("TJSJ <=", value, "tJSJ");
            return (Criteria) this;
        }

        public Criteria andTJSJLike(String value) {
            addCriterion("TJSJ like", value, "tJSJ");
            return (Criteria) this;
        }

        public Criteria andTJSJNotLike(String value) {
            addCriterion("TJSJ not like", value, "tJSJ");
            return (Criteria) this;
        }

        public Criteria andTJSJIn(List<String> values) {
            addCriterion("TJSJ in", values, "tJSJ");
            return (Criteria) this;
        }

        public Criteria andTJSJNotIn(List<String> values) {
            addCriterion("TJSJ not in", values, "tJSJ");
            return (Criteria) this;
        }

        public Criteria andTJSJBetween(String value1, String value2) {
            addCriterion("TJSJ between", value1, value2, "tJSJ");
            return (Criteria) this;
        }

        public Criteria andTJSJNotBetween(String value1, String value2) {
            addCriterion("TJSJ not between", value1, value2, "tJSJ");
            return (Criteria) this;
        }
        
			
		 public Criteria andLikeQuery(BusDailyLog record) {
		 	List<String> list= new ArrayList<String>();
		 	List<String> list2= new ArrayList<String>();
        	StringBuffer buffer=new StringBuffer();
			if(record.getID()!=null&&StrUtil.isNotEmpty(record.getID().toString())) {
    			 list.add("ifnull(ID,'')");
    		}
			if(record.getRBRQ()!=null&&StrUtil.isNotEmpty(record.getRBRQ().toString())) {
    			 list.add("ifnull(RBRQ,'')");
    		}
			if(record.getXQJ()!=null&&StrUtil.isNotEmpty(record.getXQJ().toString())) {
    			 list.add("ifnull(XQJ,'')");
    		}
			if(record.getTQ()!=null&&StrUtil.isNotEmpty(record.getTQ().toString())) {
    			 list.add("ifnull(TQ,'')");
    		}
			if(record.getSGBW()!=null&&StrUtil.isNotEmpty(record.getSGBW().toString())) {
    			 list.add("ifnull(SGBW,'')");
    		}
			if(record.getSGNR()!=null&&StrUtil.isNotEmpty(record.getSGNR().toString())) {
    			 list.add("ifnull(SGNR,'')");
    		}
			if(record.getXXJD()!=null&&StrUtil.isNotEmpty(record.getXXJD().toString())) {
    			 list.add("ifnull(XXJD,'')");
    		}
			if(record.getSGRY()!=null&&StrUtil.isNotEmpty(record.getSGRY().toString())) {
    			 list.add("ifnull(SGRY,'')");
    		}
			if(record.getSGJD()!=null&&StrUtil.isNotEmpty(record.getSGJD().toString())) {
    			 list.add("ifnull(SGJD,'')");
    		}
			if(record.getJSZLJL()!=null&&StrUtil.isNotEmpty(record.getJSZLJL().toString())) {
    			 list.add("ifnull(JSZLJL,'')");
    		}
			if(record.getJCCLJL()!=null&&StrUtil.isNotEmpty(record.getJCCLJL().toString())) {
    			 list.add("ifnull(JCCLJL,'')");
    		}
			if(record.getGCFZR()!=null&&StrUtil.isNotEmpty(record.getGCFZR().toString())) {
    			 list.add("ifnull(GCFZR,'')");
    		}
			if(record.getJLR()!=null&&StrUtil.isNotEmpty(record.getJLR().toString())) {
    			 list.add("ifnull(JLR,'')");
    		}
			if(record.getTJSJ()!=null&&StrUtil.isNotEmpty(record.getTJSJ().toString())) {
    			 list.add("ifnull(TJSJ,'')");
    		}
			if(record.getID()!=null&&StrUtil.isNotEmpty(record.getID().toString())) {
    			list2.add("'%"+record.getID()+"%'");
    		}
			if(record.getRBRQ()!=null&&StrUtil.isNotEmpty(record.getRBRQ().toString())) {
    			list2.add("'%"+record.getRBRQ()+"%'");
    		}
			if(record.getXQJ()!=null&&StrUtil.isNotEmpty(record.getXQJ().toString())) {
    			list2.add("'%"+record.getXQJ()+"%'");
    		}
			if(record.getTQ()!=null&&StrUtil.isNotEmpty(record.getTQ().toString())) {
    			list2.add("'%"+record.getTQ()+"%'");
    		}
			if(record.getSGBW()!=null&&StrUtil.isNotEmpty(record.getSGBW().toString())) {
    			list2.add("'%"+record.getSGBW()+"%'");
    		}
			if(record.getSGNR()!=null&&StrUtil.isNotEmpty(record.getSGNR().toString())) {
    			list2.add("'%"+record.getSGNR()+"%'");
    		}
			if(record.getXXJD()!=null&&StrUtil.isNotEmpty(record.getXXJD().toString())) {
    			list2.add("'%"+record.getXXJD()+"%'");
    		}
			if(record.getSGRY()!=null&&StrUtil.isNotEmpty(record.getSGRY().toString())) {
    			list2.add("'%"+record.getSGRY()+"%'");
    		}
			if(record.getSGJD()!=null&&StrUtil.isNotEmpty(record.getSGJD().toString())) {
    			list2.add("'%"+record.getSGJD()+"%'");
    		}
			if(record.getJSZLJL()!=null&&StrUtil.isNotEmpty(record.getJSZLJL().toString())) {
    			list2.add("'%"+record.getJSZLJL()+"%'");
    		}
			if(record.getJCCLJL()!=null&&StrUtil.isNotEmpty(record.getJCCLJL().toString())) {
    			list2.add("'%"+record.getJCCLJL()+"%'");
    		}
			if(record.getGCFZR()!=null&&StrUtil.isNotEmpty(record.getGCFZR().toString())) {
    			list2.add("'%"+record.getGCFZR()+"%'");
    		}
			if(record.getJLR()!=null&&StrUtil.isNotEmpty(record.getJLR().toString())) {
    			list2.add("'%"+record.getJLR()+"%'");
    		}
			if(record.getTJSJ()!=null&&StrUtil.isNotEmpty(record.getTJSJ().toString())) {
    			list2.add("'%"+record.getTJSJ()+"%'");
    		}
        	buffer.append(" CONCAT(");
	        buffer.append(StrUtil.join(",",list));
        	buffer.append(")");
        	buffer.append(" like CONCAT(");
        	buffer.append(StrUtil.join(",",list2));
        	buffer.append(")");
        	if(!" CONCAT() like CONCAT()".equals(buffer.toString())) {
        		addCriterion(buffer.toString());
        	}
        	return (Criteria) this;
        }
        
        public Criteria andLikeQuery2(String searchText) {
		 	List<String> list= new ArrayList<String>();
        	StringBuffer buffer=new StringBuffer();
    		list.add("ifnull(ID,'')");
    		list.add("ifnull(RBRQ,'')");
    		list.add("ifnull(XQJ,'')");
    		list.add("ifnull(TQ,'')");
    		list.add("ifnull(SGBW,'')");
    		list.add("ifnull(SGNR,'')");
    		list.add("ifnull(XXJD,'')");
    		list.add("ifnull(SGRY,'')");
    		list.add("ifnull(SGJD,'')");
    		list.add("ifnull(JSZLJL,'')");
    		list.add("ifnull(JCCLJL,'')");
    		list.add("ifnull(GCFZR,'')");
    		list.add("ifnull(JLR,'')");
    		list.add("ifnull(TJSJ,'')");
        	buffer.append(" CONCAT(");
	        buffer.append(StrUtil.join(",",list));
        	buffer.append(")");
        	buffer.append("like '%");
        	buffer.append(searchText);
        	buffer.append("%'");
        	addCriterion(buffer.toString());
        	return (Criteria) this;
        }
        
}
	
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}